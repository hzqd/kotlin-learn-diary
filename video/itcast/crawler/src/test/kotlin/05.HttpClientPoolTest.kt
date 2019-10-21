import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager
import org.apache.http.util.EntityUtils

fun doGet(cm: PoolingHttpClientConnectionManager) {
    HttpClients.custom().setConnectionManager(cm).build().execute(HttpGet("http://www.itcast.cn")).apply {
        if(statusLine.statusCode==200)EntityUtils.toString(entity,"utf-8").sout()
    }
}

fun main() {    //  创建连接池管理器    ==>     设置最大连接数     ==>     设置每个主机的最大连接数
    PoolingHttpClientConnectionManager().apply { maxTotal = 100 }.apply { defaultMaxPerRoute = 10 }
        .also { doGet(it) }.also { doGet(it) }.also { doGet(it) }   // 发起多条请求
}