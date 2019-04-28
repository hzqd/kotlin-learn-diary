import java.io.ByteArrayOutputStream
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.util.Base64
import javax.crypto.Cipher

object RSACrypt {
    fun encryptByPrivateKey(input: String, privateKey: PrivateKey): String {
        val byteArray = input.toByteArray()
        val cipher = Cipher.getInstance("RSA")
        cipher.init(Cipher.ENCRYPT_MODE, privateKey)
        var offset = 0
        var tmp: ByteArray
        val bos = ByteArrayOutputStream()
        while (byteArray.size - offset > 0) {
            if (byteArray.size - offset >= 117) {
                tmp = cipher.doFinal(byteArray, offset, 117)
                offset += 117
            } else {
                tmp = cipher.doFinal(byteArray, offset, byteArray.size - offset)
                offset = byteArray.size
            }
            bos.write(tmp)
        }
        bos.close()
        return Base64.getEncoder().encodeToString(bos.toByteArray())
    }

    fun encryptByPublicKey(input: String, publicKey: PublicKey): String {
        val byteArray = input.toByteArray()
        val cipher = Cipher.getInstance("RSA")
        cipher.init(Cipher.ENCRYPT_MODE, publicKey)
        var offset = 0
        var tmp: ByteArray
        val bos = ByteArrayOutputStream()
        while (byteArray.size - offset > 0) {
            if (byteArray.size - offset >= 117) {
                tmp = cipher.doFinal(byteArray, offset, 117)
                offset += 117
            } else {
                tmp = cipher.doFinal(byteArray, offset, byteArray.size - offset)
                offset = byteArray.size
            }
            bos.write(tmp)
        }
        bos.close()
        return Base64.getEncoder().encodeToString(bos.toByteArray())
    }

    fun decryptByPrivateKey(input: String, privateKey: PrivateKey): String {
        val byteArray = Base64.getDecoder().decode(input)
        val cipher = Cipher.getInstance("RSA")
        cipher.init(Cipher.DECRYPT_MODE, privateKey)
        var offset = 0
        var tmp: ByteArray
        val bos = ByteArrayOutputStream()
        while (byteArray.size - offset > 0) {
            if (byteArray.size - offset >= 256) {
                tmp = cipher.doFinal(byteArray, offset, 256)
                offset += 256
            } else {
                tmp = cipher.doFinal(byteArray, offset, byteArray.size - offset)
                offset = byteArray.size
            }
            bos.write(tmp)
        }
        bos.close()
        return String(bos.toByteArray())
    }

    fun decryptByPublicKey(input: String, publicKey: PublicKey): String {
        val byteArray = Base64.getDecoder().decode(input)
        val cipher = Cipher.getInstance("RSA")
        cipher.init(Cipher.DECRYPT_MODE, publicKey)
        var offset = 0
        var tmp: ByteArray
        val bos = ByteArrayOutputStream()
        while (byteArray.size - offset > 0) {
            if (byteArray.size - offset >= 256) {
                tmp = cipher.doFinal(byteArray, offset, 256)
                offset += 256
            } else {
                tmp = cipher.doFinal(byteArray, offset, byteArray.size - offset)
                offset = byteArray.size
            }
            bos.write(tmp)
        }
        bos.close()
        return String(bos.toByteArray())
    }
}

fun main() {
    val keyPair = KeyPairGenerator.getInstance("RSA").genKeyPair()
    val publicKey = keyPair.public
    val privateKey = keyPair.private
    println("publicKey=" + Base64.getEncoder().encodeToString(publicKey.encoded))
    println("privateKey=" + Base64.getEncoder().encodeToString(privateKey.encoded))
    val input = """
        |今天天气不错，我的心情也不错！
        |momo不小心吃了过期好几天的肉，mili写了Rosetta。
        |momo不小心吃了过期两个月的肉，mili写了Imagine Flight。
        |momo不小心吃了过期的三明治，mili写了Ga1ahad----。
        |momo梦游把自家电路板吃了，mili写了world.execute(me);
    """.trimMargin()
    val encryptByPrivateKey = RSACrypt.encryptByPrivateKey(input, privateKey)
    println("私钥加密=$encryptByPrivateKey")
    val encryptByPublicKey = RSACrypt.encryptByPublicKey(input, publicKey)
    println("公钥加密=$encryptByPublicKey")
    val decryptByPrivateKey = RSACrypt.decryptByPrivateKey(encryptByPublicKey, privateKey)
    println("私钥解密=$decryptByPrivateKey")
    val decryptByPublicKey = RSACrypt.decryptByPublicKey(encryptByPrivateKey, publicKey)
    println("公钥解密=$decryptByPublicKey")
}