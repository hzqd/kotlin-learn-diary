import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
fun main() {
    HttpClients.createDefault().execute(HttpPost("http://www.itcast.cn/")).apply {
        if (statusLine.statusCode == 200) {
            EntityUtils.toString(entity, "utf-8").sout()
        }
    }
}