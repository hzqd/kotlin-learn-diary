import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec

object DESCrypt {
    fun encrypt(input: String, passwd: String): ByteArray {
        //1.创建cipher对象：
        val cipher = Cipher.getInstance("DES")
        //2.初始化cipher：
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeyFactory.getInstance("DES").generateSecret(DESKeySpec(passwd.toByteArray())))
        //3.加密：
        return cipher.doFinal(input.toByteArray())
    }
    fun decrypt(input: ByteArray, passwd: String): ByteArray {
        //1.创建cipher对象：
        val cipher = Cipher.getInstance("DES")
        //2.初始化cipher：
        cipher.init(Cipher.DECRYPT_MODE, SecretKeyFactory.getInstance("DES").generateSecret(DESKeySpec(passwd.toByteArray())))
        //3.解密：
        return cipher.doFinal(input)
    }
}

fun main() {
    val input = "欢迎来到黑马程序员" //原文
    val passwd = "12345678" //秘钥
    val encrypt = DESCrypt.encrypt(input, passwd)
    val decrypt = DESCrypt.decrypt(encrypt, passwd)
    println("DES加密：$encrypt\nDES解密：" + String(decrypt))
}