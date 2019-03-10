package com.example.kotlinwithhtml

import android.content.Context
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast
import org.json.JSONObject
import java.net.URL

/**
 * Kotlin与H5通信桥梁类
 */
class JavaScriptMethods {
    private var mContext: Context? = null
    private var mWebView: WebView? = null

    constructor(Context: Context?, webview: WebView?) {
        this.mContext = Context
        this.mWebView = webview
    }

    @JavascriptInterface /*Android4.2之后，不加此注解，H5不能调用kotlin函数*/
    fun showToast(json: String) {
        //Toast.makeText(mContext, json, Toast.LENGTH_SHORT).show()
        //mContext.let { it?.toast(json) }
        mContext?.toast(json)
    }

    @JavascriptInterface
    fun getHotelData(json: String) {
        val jsJson=JSONObject(json)
        val callback=jsJson.optString("callback")
        //异步操作，子线程请求服务器
        doAsync {
            var url = URL("")
            val result = url.readText()
            println("获取酒店数据$result")
            //回传数据给H5，调用js函数必须在主线程
            mContext?.runOnUiThread { mWebView?.loadUrl("javascript:$callback($result)") }
        }
    }
}