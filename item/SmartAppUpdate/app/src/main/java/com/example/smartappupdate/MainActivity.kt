package com.example.smartappupdate

import android.app.ProgressDialog
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk27.coroutines.onClick
import java.io.File

class MainActivity : AppCompatActivity() {

    private val mDialog: ProgressDialog by lazy { ProgressDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //findViewById<>()之后，设置点击监听
        btn_update.onClick {
            //集成增量更新：https://github.com/jiyouliang2/SmartUpdateDemo
            update()
        }
    }

    //增量更新
    fun update() {
        var pm: PackageManager = packageManager
        //应用程序信息
        val appInfo = pm.getApplicationInfo("com.ss.android.article.news", 0)

        //1.获取旧版本apk路径
        val oldPath = appInfo.sourceDir
        //2.指定patch文件保存路径
        var patchFile = File(Environment.getExternalStorageDirectory(), "toutiao.patch")
        //3.设置新版本apk保留路径
        var newApkFile = File(Environment.getExternalStorageDirectory(), "toutiao_new.apk")
        //4.合并生成新版本
        mDialog.show()
        //子线程
        doAsync {
            //缺少PatchUtil.patch(oldPatch, newApkFile.absolutePatch, patchFile.absolutePatch)
            //合并完成
            runOnUiThread { mDialog.dismiss() }
        }
    }
}