import org.apache.http.NameValuePair
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.HttpClients
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils

fun main() {
    HttpPost("http://yun.itheima.com/search").apply {
        entity = UrlEncodedFormEntity(
            ArrayList<NameValuePair>()
                .apply { add(BasicNameValuePair("keys", "Java")) },
            "utf-8"
        )
    }.let { HttpClients.createDefault().execute(it) }.apply {
        if (statusLine.statusCode == 200) {
            EntityUtils.toString(entity, "utf-8").sout()
        }
    }
}