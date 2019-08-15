package itcast

import java.util.Random

class HttpUtil {
    fun sendRequest(path: String?, method: String?, onSuccess: ((String) -> Unit)?, onError: ((String) -> Unit)?) {
        println("pth=$path method=$method")
        Thread {
            //val url = URL(path)
            println("创建URL")
            //val conn = url.openConnection() as HttpURLConnection
            println("打开网络连接")
            val code = Random().nextInt(100)
            //val resCode = conn.responseCode
            println("获取响应码")
            when (code % 2 == 0) {
                true -> onSuccess?.invoke("结果正确")
                false -> onError?.invoke("响应码不正确")
            }
        }.start()
    }
}
class MyRequest(var path:String?=null,var method:String?=null,var onSuccess:((String)->Unit)?=null,var onError:((String)->Unit)?=null){
    fun send() = HttpUtil().sendRequest(path, method, onSuccess, onError)
}

fun http(block:MyRequest.()->Unit) = MyRequest().apply(block).send()
fun MyRequest.onSuccess(block: (String) -> Unit) = run { onSuccess = block }
fun MyRequest.onError(block: (String) -> Unit) = run { onError = block }

fun main() {
    http {
        path = "http://www.baidu.com"
        method = "GET"
        onSuccess{
            println("成功")
        }
        onError{
            println("失败")
        }
    }
}