import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

fun Any.sout() = let(::println)
fun main() {
    HttpClients.createDefault().execute(HttpGet("http://www.itcast.cn/")).also {
        if (it.statusLine.statusCode == 200) {
            EntityUtils.toString(it.entity, "utf-8").sout()
        }
    }
}