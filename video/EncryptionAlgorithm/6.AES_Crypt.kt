import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

object AESCrypt {
    fun encrypt(input: String, passwd: String): ByteArray? {
        //1.创建cipher对象：
        val cipher = Cipher.getInstance("AES")
        //2.初始化cipher：
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(passwd.toByteArray(), "AES"))
        //3.加密：
        return cipher.doFinal(input.toByteArray())
    }

    fun decrypt(input: ByteArray?, passwd: String): ByteArray? {
        //1.创建cipher对象：
        val cipher = Cipher.getInstance("AES")
        //2.初始化cipher：
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(passwd.toByteArray(), "AES"))
        //3.解密：
        return cipher.doFinal(input)
    }
}

fun main() {
    val input = "欢迎来到黑马程序员"
    val passwd = "1234567812345678"
    val encrypt = AESCrypt.encrypt(input, passwd)
    val decrypt = AESCrypt.decrypt(encrypt, passwd)
    println("DES加密：$encrypt\nDES解密：" + String(decrypt!!))
}