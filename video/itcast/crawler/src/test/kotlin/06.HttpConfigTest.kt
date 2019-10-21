import org.apache.http.client.config.RequestConfig
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

fun main() {
    HttpGet("http://www.itcast.cn/").apply {
        config = RequestConfig.custom()
            .setConnectTimeout(1000)            //创建连接的最长时间，单位是毫秒
            .setConnectionRequestTimeout(500)   //获取连接的最长时间
            .setSocketTimeout(10*1000)          //数据传输的最长时间
            .build()
    }.let { HttpClients.createDefault().execute(it) }.apply {
        if (statusLine.statusCode == 200) {
            EntityUtils.toString(entity, "utf-8").sout()
        }
    }
}