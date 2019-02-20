import java.io.BufferedReader
import java.io.FileReader

fun main() {
    val passwd = readLine()!!
    val input = BufferedReader(FileReader("encrypt")).readLine()
    println("AES解密：" + String(AESCrypt.decrypt(input, passwd)))
}
