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

    fun encrypt(input: String, passwd: String) = with(input) {
        desCrypt(passwd, "encrypt").doFinal(toByteArray()).base64Encode()
    }

    fun decrypt(input: String, passwd: String) = with(input) {
        desCrypt(passwd, "decrypt").run {
            String(base64Decode().let(::doFinal))
        }
    }
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

    fun encrypt(input: String, passwd: String) = with(input) {
        aesCrypt(passwd, "encrypt").doFinal(toByteArray()).base64Encode()
    }

    fun decrypt(input: String, passwd: String) = with(input) {
        aesCrypt(passwd, "decrypt").run {
            String(base64Decode().let(::doFinal))
        }
    }
}

sealed class Option<out T>
data class Some<out T>(val v: T) : Option<T>()
object None : Option<Nothing>()

enum class Crypto {
    Encrypt, Decrypt
}

object RSACrypt {
    private fun rsaCrypt(
        input: String, mode: Crypto, privateKey: Option<PrivateKey> = None, publicKey: Option<PublicKey> = None,
    ) = run {
        var offset = 0
        var tmp: ByteArray
        (if (mode == Crypto.Encrypt) 117 else 256).let {
            with(Cipher.getInstance("RSA")) {
                init(
                    if (mode == Crypto.Encrypt) Cipher.ENCRYPT_MODE else Cipher.DECRYPT_MODE,
                    if (privateKey is Some) privateKey.v else (publicKey as Some).v
                )
                with(ByteArrayOutputStream()) {
                    (if (mode == Crypto.Encrypt) input.toByteArray() else input.base64Decode()).run {
                        while (size - offset > 0) {
                            if (size - offset >= it) {
                                tmp = doFinal(this, offset, it)
                                offset += it
                            } else {
                                tmp = doFinal(this, offset, size - offset)
                                offset = size
                            }
                            tmp.let(::write)
                        }
                        close()
                        toByteArray()
                    }
                }
            }
        }
    }

    fun encryptByPrivateKey(input: String, privateKey: PrivateKey) =
        rsaCrypt(input, Crypto.Encrypt, Some(privateKey)).base64Encode()

    fun encryptByPublicKey(input: String, publicKey: PublicKey) =
        rsaCrypt(input, Crypto.Encrypt, publicKey = Some(publicKey)).base64Encode()

    fun decryptByPrivateKey(input: String, privateKey: PrivateKey) =
        String(rsaCrypt(input, Crypto.Decrypt, Some(privateKey)))

    fun decryptByPublicKey(input: String, publicKey: PublicKey) =
        String(rsaCrypt(input, Crypto.Decrypt, publicKey = Some(publicKey)))
}

fun encrypt() {
    var input = ""
    var name = ""
    println("直接输入请输1 读取文件请输2")
    when (readLine()) {
        "1" -> {
            println("请输入您要加密的内容:")
            input = readLine()!!
            println("请输入加密后的文件名:")
            name = readLine()!!
        }
        "2" -> {
            println("请输入该文件名:")
            input = readLine()!!.also { name = it }.let(::FileReader).readText()
        }
    }
    println("请输入AES的16位密码:")
    AESCrypt.encrypt(input, readLine()!!).also { println("请输入DES的8位密码:") }.let { DESCrypt.encrypt(it, readLine()!!) }
        .let {
            KeyPairGenerator.getInstance("RSA").genKeyPair().also { println("公钥加密请输1 私钥加密请输2") }.run {
                when (readLine()) {
                    "1" -> FileWriter("${name}_encryptByPublicKey").apply {
                        RSACrypt.encryptByPublicKey(it, public).let(::write)
                    }.close()
                    "2" -> FileWriter("${name}_encryptByPrivateKey").apply {
                        RSACrypt.encryptByPrivateKey(it, private).let(::write)
                    }.close()
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
        KeyFactory.getInstance("RSA").run {
            when (readLine()) {
                "1" -> {
                    println("请输入私钥文件名")
                    readLine().let(::FileReader).readText().base64Decode().let(::PKCS8EncodedKeySpec)
                        .let(::generatePrivate)
                        .let { RSACrypt.decryptByPrivateKey(input, it) }
                }
                "2" -> {
                    println("请输入公钥文件名")
                    readLine().let(::FileReader).readText().base64Decode().let(::X509EncodedKeySpec)
                        .let(::generatePublic)
                        .let { RSACrypt.decryptByPublicKey(input, it) }
                }
                else -> Unit
            }
        }
    }.also { println("请输入DES的8位密码:") }.let { DESCrypt.decrypt(it as String, readLine()!!) }
        .also { println("请输入AES的16位密码:") }.let { AESCrypt.decrypt(it, readLine()!!) }
        .also { println("输出到屏幕请输1 输出到文件请输2") }.let {
            when (readLine()) {
                "1" -> println("三重解密：\n$it\n解密完成\n")
                "2" -> {
                    println("请输入解密后的文件名")
                    readLine().let(::FileWriter).apply { it.let(::write) }.close()
                    println("解密完成\n")
                }
            }
        }
}

fun main() {
    while (true) {
        println("加密请输1  解密请输2")
        when (readLine()) {
            "1" -> encrypt()
            "2" -> decrypt()
        }
    }
}
