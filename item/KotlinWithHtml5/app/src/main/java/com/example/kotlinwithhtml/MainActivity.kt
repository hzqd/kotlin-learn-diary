package com.example.kotlinwithhtml

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    //初始化View对象：findViewById -> 懒加载，使用了才初始化:
    private val mWebView: WebView by lazy { webview }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setWebView
    }

    /**知识点：Lambda 表达式
     * val add = { a: Int, b: Int, c: Int -> a + b * c }
     */
    private val setWebView = {
        //1.开启kotlin与H5的通信开关
        mWebView.settings.javaScriptEnabled = true
        //2.设置2个WebViewClient
        mWebView.webViewClient = MyWebViewClient()
        mWebView.webChromeClient = MyWebChromeClient()
        /*Kotlin与H5通信方式1：H5调用kotlin方法
         *设置Kotlin与H5通信桥梁类
         *mWebView.addJavascriptInterface(对象，字符串)：对象.函数名，字符串：参数对象的别名
         */
        mWebView.addJavascriptInterface(JavaScriptMethods(this, mWebView), "jsInterface")
        //3.加载网页
        mWebView.loadUrl("")
    }

    private inner class MyWebViewClient : WebViewClient() {
        //页面加载完成调用
        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            /*Kotlin与H5通信方式2：kotlin调用H5方法*/
            //mWebView.loadUrl("javascript:方法名(参数)")
            val json = JSONObject()
            json.put("name", "Kotlin")
            mWebView.loadUrl("javascript:showMessage($json)")
        }
    }

    private class MyWebChromeClient : WebChromeClient() {
        //加载进度条
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
        }
    }
}
