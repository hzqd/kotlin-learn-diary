import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

object AESCrypt {
    fun encrypt(input: String, passwd: String): String {
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(passwd.toByteArray(), "AES"))
        return Base64.getEncoder().encodeToString(cipher.doFinal(input.toByteArray()))
    }
    fun decrypt(input: String, passwd: String): ByteArray {
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(passwd.toByteArray(), "AES"))
        return cipher.doFinal(Base64.getDecoder().decode(input))
    }
}

fun en() {
    println("请输入您要加密的内容:")
    val input = readLine()!!
    println("请您输入至少16位密码:")
    val passwd = readLine()!!
    println("请输入加密后的文件名:")
    val bw = BufferedWriter(FileWriter("${readLine()}"))
    bw.write(AESCrypt.encrypt(input, passwd))
    bw.close()
    println("加密完成\n")
}

fun de() {
    println("请输入该文件名:")
    val input = BufferedReader(FileReader("${readLine()}")).readLine()
    println("请输入解密密码:")
    println("AES解密：" + String(AESCrypt.decrypt(input, readLine()!!)) + "\n解密完成\n")
}

fun main() {
    while (true) {
        println("加密请输1  解密请输2")
        when (readLine()) {
            "1" -> en()
            "2" -> de()
        }
    }
}
