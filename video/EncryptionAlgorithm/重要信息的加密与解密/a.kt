import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

object AESCrypt {
    fun encrypt(input: String, passwd: String): String {
        //1.创建cipher对象：
        val cipher = Cipher.getInstance("AES")
        //2.初始化cipher：
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(passwd.toByteArray(), "AES"))
        //3.加密：
        return Base64.getEncoder().encodeToString(cipher.doFinal(input.toByteArray()))
    }

    fun decrypt(input: String, passwd: String): ByteArray {
        //1.创建cipher对象：
        val cipher = Cipher.getInstance("AES")
        //2.初始化cipher：
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(passwd.toByteArray(), "AES"))
        //3.解密：
        return cipher.doFinal(Base64.getDecoder().decode(input))
    }
}

fun en() {
    println("请输入您要加密的内容:")
    val input = readLine()!!
    println("请您输入至少16位密码:")
    val passwd = readLine()!!
    val encrypt = AESCrypt.encrypt(input, passwd)
    println("请输入加密后的文件名:")
    val br = BufferedWriter(FileWriter("${readLine()}"))
    br.write(encrypt)
    br.close()
    println("加密完成")
}

fun de() {
    println("请输入该文件名:")
    val input = BufferedReader(FileReader("${readLine()}")).readLine()
    println("请输入解密密码:")
    val passwd = readLine()!!
    println("AES解密：" + String(AESCrypt.decrypt(input, passwd)) + "\n解密完成")
}

fun main() {
    while (true) {
        println("加密请输1  解密请输2")
        val mode = readLine()
        when (mode) {
            "1" -> en()
            "2" -> de()
        }
    }
}
