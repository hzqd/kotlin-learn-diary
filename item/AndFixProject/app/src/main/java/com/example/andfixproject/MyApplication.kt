package com.example.andfixproject

import android.app.Application
import android.os.Environment
import com.alipay.euler.andfix.patch.PatchManager
import java.io.File

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        //初始化阿里AndFix的PatchManager
        val patchManager = PatchManager(this)
        patchManager.init("1.0")
        //加载patch
        patchManager.loadPatch()
        //设置补丁文件路径
        var pathFile = File(Environment.getExternalStorageDirectory(), "fixbug.apatch")
        //合并补丁文件
        if (pathFile.exists()) {
            patchManager.addPatch(pathFile.absolutePath)
        }
    }
}