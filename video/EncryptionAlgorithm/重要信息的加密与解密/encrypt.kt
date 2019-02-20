import java.io.BufferedWriter
import java.io.FileWriter

fun main() {
    val input = """
        |
    """.trimMargin()
    val passwd = "保密内容"
    val encrypt = AESCrypt.encrypt(input, passwd)
    val br = BufferedWriter(FileWriter("encrypt"))
    br.write(encrypt)
    br.close()
}
