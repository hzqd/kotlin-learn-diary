import java.io.ByteArrayOutputStream
import java.io.FileReader
import java.io.FileWriter
import java.security.KeyFactory
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec
import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory.getInstance
import javax.crypto.spec.DESKeySpec
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

fun ByteArray.base64Encode() = Base64.getEncoder().encodeToString(this)
fun String.base64Decode() = Base64.getDecoder().decode(this)

object DESCrypt {
    private fun desCrypt(passwd: String, mode: String) = with(passwd) {
        Cipher.getInstance("DES/CBC/PKCS5Padding").apply {
            init(
                if (mode == "encrypt") Cipher.ENCRYPT_MODE else Cipher.DECRYPT_MODE,
                toByteArray().let(::DESKeySpec).let(getInstance("DES")::generateSecret),
                toByteArray().let(::IvParameterSpec)
            )
        }
    }

    fun encrypt(input: String, passwd: String) = with(input) { desCrypt(passwd, "encrypt").doFinal(toByteArray()).base64Encode() }
    fun decrypt(input: String, passwd: String) = with(input) { desCrypt(passwd, "decrypt").run{ String(base64Decode().let(::doFinal)) }}
}

object AESCrypt {
    private fun aesCrypt(passwd: String, mode: String) = with(passwd) {
        Cipher.getInstance("AES/CBC/PKCS5Padding").apply {
            init(
                if (mode == "encrypt") Cipher.ENCRYPT_MODE else Cipher.DECRYPT_MODE,
                Pair(toByteArray(), "AES").run { SecretKeySpec(first, second) },
                toByteArray().let(::IvParameterSpec)
            )
        }
    }

    fun encrypt(input: String, passwd: String) = with(input) { aesCrypt(passwd, "encrypt").doFinal(toByteArray()).base64Encode() }
    fun decrypt(input: String, passwd: String) = with(input) { aesCrypt(passwd, "decrypt").run{ String(base64Decode().let(::doFinal)) }}
}

object RSACrypt {
    private fun rsaCrypt(
        input: String, mode: String, type: String, privateKey: PrivateKey? = null, publicKey: PublicKey? = null
    ) = run {
        val byteArray = if (mode == "encrypt") input.toByteArray() else input.base64Decode()
        val cipher = Cipher.getInstance("RSA")
        cipher.init(
            if (mode == "encrypt") Cipher.ENCRYPT_MODE else Cipher.DECRYPT_MODE,
            if (type == "private") privateKey else publicKey
        )
        var offset = 0
        var tmp: ByteArray
        val cipherLen = if (mode == "encrypt") 117 else 256
        with(ByteArrayOutputStream()) {
            while (byteArray.size - offset > 0) {
                if (byteArray.size - offset >= cipherLen) {
                    tmp = cipher.doFinal(byteArray, offset, cipherLen)
                    offset += cipherLen
                } else {
                    tmp = cipher.doFinal(byteArray, offset, byteArray.size - offset)
                    offset = byteArray.size
                }
                write(tmp)
            }
            close()
            toByteArray()
        }
    }

    fun encryptByPrivateKey(input: String, privateKey: PrivateKey) = rsaCrypt(input, "encrypt", "private", privateKey).base64Encode()
    fun encryptByPublicKey(input:String,publicKey:PublicKey)=rsaCrypt(input,"encrypt","public",publicKey=publicKey).base64Encode()
    fun decryptByPrivateKey(input: String, privateKey: PrivateKey) = String(rsaCrypt(input, "decrypt", "private", privateKey))
    fun decryptByPublicKey(input: String, publicKey: PublicKey) = String(rsaCrypt(input, "decrypt", "public", publicKey = publicKey))
}

fun encrypt() {
    println("请输入您要加密的内容:")
    val input = readLine()!!
    println("请输入加密后的文件名:")
    val name = readLine()!!
    println("请输入AES的16位密码:")
    AESCrypt.encrypt(input, readLine()!!).also { println("请输入DES的8位密码:") }.let { DESCrypt.encrypt(it, readLine()!!) }.let {
        KeyPairGenerator.getInstance("RSA").genKeyPair().run {
            println("公钥加密请输1 私钥加密请输2")
            when (readLine()) {
                "1" -> FileWriter("${name}_encryptByPublicKey").apply { RSACrypt.encryptByPublicKey(it, public).let(::write) }.close()
                "2" -> FileWriter("${name}_encryptByPrivateKey").apply{ RSACrypt.encryptByPrivateKey(it, private).let(::write) }.close()
            }
            FileWriter("${name}_privateKey").apply { private.encoded.base64Encode().let(::write) }.close()
            FileWriter("${name}_publicKey").apply { public.encoded.base64Encode().let(::write) }.close()
        }
    }
    println("三重加密完成\n")
}

fun decrypt() {
    println("请输入该文件名:")
    readLine().let(::FileReader).readText().also { println("私钥解密请输1 公钥解密请输2") }.let { input ->
        KeyFactory.getInstance("RSA").run { when (readLine()) {
            "1" -> {
                println("请输入私钥文件名")
                readLine().let(::FileReader).readText().base64Decode().let(::PKCS8EncodedKeySpec).let(::generatePrivate)
                    .let { RSACrypt.decryptByPrivateKey(input, it) }
            }
            "2" -> {
                println("请输入公钥文件名")
                readLine().let(::FileReader).readText().base64Decode().let(::X509EncodedKeySpec).let(::generatePublic)
                    .let { RSACrypt.decryptByPublicKey(input, it) }
            }
            else -> Unit
        } }
    }.also { println("请输入DES的8位密码:") }.let { DESCrypt.decrypt(it as String, readLine()!!) }
        .also { println("请输入AES的16位密码:") }.let { println("三重解密：\n${AESCrypt.decrypt(it, readLine()!!)}\n解密完成\n") }
}

fun main() {
    while (true) { println("加密请输1  解密请输2")
        when (readLine()) {
            "1" -> encrypt()
            "2" -> decrypt()
        }
    }
}
