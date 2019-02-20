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
