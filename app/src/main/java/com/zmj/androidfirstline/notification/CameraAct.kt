package com.zmj.androidfirstline.notification

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.zmj.androidfirstline.R
import kotlinx.android.synthetic.main.act_camera.*
import java.io.File

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/18
 * Description :
 */
class CameraAct: AppCompatActivity() {

    val takePhoto = 1
    val openGallery = 2
    private lateinit var imageUri: Uri
    private lateinit var outputImage: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_camera)

        openCamera.setOnClickListener {
            prepareTakePhoto()
        }

        openAlbum.setOnClickListener {
            prepareOpenGallery()
        }

    }

    private fun prepareTakePhoto(){
        //创建File对象，用于存储拍照后的照片
        outputImage = File(externalCacheDir,"output_image.jpg")
        if (outputImage.exists()){
            outputImage.delete()
        }
        outputImage.createNewFile()
        imageUri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            FileProvider.getUriForFile(this,"XXXXXXXXXX",outputImage)
        }else{
            Uri.fromFile(outputImage)
        }
        //启动相机
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri)
        startActivityForResult(intent,takePhoto)
    }

    private fun prepareOpenGallery(){
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "image/*"
        startActivityForResult(intent,openGallery)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            takePhoto -> {
                if (resultCode == Activity.RESULT_OK){
                    //取出照片
                    val bitmap = BitmapFactory.decodeStream(applicationContext.contentResolver.openInputStream(imageUri))
                    image.setImageBitmap(rotateIfRequired(bitmap))
                }
            }
            openGallery -> {
                if (resultCode == Activity.RESULT_OK && data != null){
                    data.data?.let { uri ->
                        val bitmap = getBitmapFromUri(uri)
                        image.setImageBitmap(bitmap)
                    }
                }
            }
        }
    }

    private fun getBitmapFromUri(uri: Uri) = applicationContext.contentResolver
        .openAssetFileDescriptor(uri,"r")?.use {
            BitmapFactory.decodeFileDescriptor(it.fileDescriptor)
        }


    //图片角度矫正
    private fun rotateIfRequired(bitmap:Bitmap):Bitmap{
        val exif = ExifInterface(outputImage.path)
        val orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,ExifInterface.ORIENTATION_NORMAL)
        return when(orientation){
            ExifInterface.ORIENTATION_ROTATE_90 -> rotateBitmap(bitmap,90)
            ExifInterface.ORIENTATION_ROTATE_180 -> rotateBitmap(bitmap,180)
            ExifInterface.ORIENTATION_ROTATE_270 -> rotateBitmap(bitmap,270)
            else -> bitmap
        }
    }

    private fun rotateBitmap(bitmap: Bitmap,degree: Int):Bitmap{
        val matrix = Matrix()
        matrix.postRotate(degree.toFloat())
        val rotatedBitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.width,bitmap.height,matrix,true)

        bitmap.recycle()    //回收
        return rotatedBitmap
    }
}