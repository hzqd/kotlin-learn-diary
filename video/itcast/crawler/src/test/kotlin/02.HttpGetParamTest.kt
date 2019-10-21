import org.apache.http.client.methods.HttpGet
import org.apache.http.client.utils.URIBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils

fun main() {
    HttpClients.createDefault().execute(
        HttpGet(
            URIBuilder("http://yun.itheima.com/search")
                .setParameter("keys", "Java").build()
        )
    ).apply {
        if (statusLine.statusCode == 200) {
            EntityUtils.toString(entity, "utf-8").sout()
        }
    }
}