package com.zmj.androidfirstline.apklinstall

import android.Manifest
import android.app.Activity
import android.app.DownloadManager
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.zmj.androidfirstline.App
import com.zmj.androidfirstline.R
import com.zmj.androidfirstline.common.showToast
import com.zmj.permissionlib.Permission
import com.zmj.permissionlib.PermissionCallBack
import kotlinx.android.synthetic.main.act_apk_install.*
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * GitHub : https://github.com/ZmjDns
 * Time : 2020/8/24
 * Description :
 */
class ApkInstallAct : AppCompatActivity(){

    val path = "/storage/emulated/0/Download/FDex2_1.1.apk"//"/storage/emulated/0/Download/newApk.apk"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.act_apk_install)

        install.setOnClickListener {
            getFilePermisson()

        }
    }

    fun getFilePermisson(){
        //requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE),110)

        if (Build.VERSION.SDK_INT >= 23){
            Permission.request(this,
                /*Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,*/
                Manifest.permission.REQUEST_INSTALL_PACKAGES){allGranted,denyList ->
                    if (allGranted){
                        installPackages()
                    }else{
                        showToast("you denyed $denyList")
                    }
                installPackages()
                }
        }
    }

    private fun installPackages() {
        val file = File(path)
        if (!file.exists()){
            showToast("找不到文件")
            return
        }
        val apkUri: Uri
        val installIntent = Intent(Intent.ACTION_VIEW)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){

            apkUri = FileProvider.getUriForFile(this,"XXXXXXXXXX",file)
            installIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)//一定要加，否则可能出现解析安装包失败的问题

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                val aa = packageManager.canRequestPackageInstalls()
                if (!aa){
                   showToast("can not install unknown apk source please setting")
                    return
                }
            }
        }else{
            apkUri = Uri.fromFile(file)
        }

        installIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        installIntent.setDataAndType(apkUri,"application/vnd.android.package-archive")
        startActivity(installIntent)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun checkAPIOInstallPermission(){
        val packageUri = Uri.parse("package:$packageName")
        val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES,packageUri)
        startActivityForResult(intent,2020)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 2020 && resultCode == Activity.RESULT_OK){
            showToast("Got install unknown apk resource permission")
        }else{
            showToast("you denied permission can not install apk")
        }
    }

    private fun downLoadApk(){
        //App.appContext.externalCacheDir属于应用内部的dir，无需请求权限
        //App.appContext.getExternalFilesDir()也属于应用内部的dir，无需请求权限

        val file = File(App.appContext.externalCacheDir,"newVersion.apk")
        if (file.exists()){
            file.delete()
        }
        //write file Stream to file
        //val instream =
        val output = FileOutputStream(file)




    }
}