import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {
    val data = Date()
    val dateFormat = "yyyy-MM-dd HH:mm:ss"
    val simpleDateFormat = SimpleDateFormat(dateFormat)
    println(simpleDateFormat.format(data))
}