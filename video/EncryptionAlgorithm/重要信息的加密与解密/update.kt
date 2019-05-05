import java.io.BufferedReader
import java.io.BufferedWriter
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
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec
import javax.crypto.spec.SecretKeySpec

object DESCrypt {
    fun encrypt(input: String, passwd: String): String {
        val cipher = Cipher.getInstance("DES")
        cipher.init(
            Cipher.ENCRYPT_MODE,
            SecretKeyFactory.getInstance("DES").generateSecret(DESKeySpec(passwd.toByteArray()))
        )
        return Base64.getEncoder().encodeToString(cipher.doFinal(input.toByteArray()))
    }

    fun decrypt(input: String, passwd: String): ByteArray {
        val cipher = Cipher.getInstance("DES")
        cipher.init(
            Cipher.DECRYPT_MODE,
            SecretKeyFactory.getInstance("DES").generateSecret(DESKeySpec(passwd.toByteArray()))
        )
        return cipher.doFinal(Base64.getDecoder().decode(input))
    }
}

fun desEN() {
    println("请输入您要加密的内容:")
    val input = readLine()!!
    println("请您输入至少8位密码:")
    val passwd = readLine()!!
    println("请输入加密后的文件名:")
    val bw = BufferedWriter(FileWriter(readLine()))
    bw.write(DESCrypt.encrypt(input, passwd))
    bw.close()
    println("加密完成\n")
}

fun desDE() {
    println("请输入该文件名:")
    val input = BufferedReader(FileReader(readLine())).readLine()
    println("请输入解密密码:")
    println("DES解密：" + String(DESCrypt.decrypt(input, readLine()!!)) + "\n解密完成\n")
}

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

fun aesEN() {
    println("请输入您要加密的内容:")
    val input = readLine()!!
    println("请您输入至少16位密码:")
    val passwd = readLine()!!
    println("请输入加密后的文件名:")
    val bw = BufferedWriter(FileWriter(readLine()))
    bw.write(AESCrypt.encrypt(input, passwd))
    bw.close()
    println("加密完成\n")
}

fun aesDE() {
    println("请输入该文件名:")
    val input = BufferedReader(FileReader(readLine())).readLine()
    println("请输入解密密码:")
    println("AES解密：" + String(AESCrypt.decrypt(input, readLine()!!)) + "\n解密完成\n")
}

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

fun rsaEN() {
    val keyPair = KeyPairGenerator.getInstance("RSA").genKeyPair()
    val publicKey = keyPair.public
    val privateKey = keyPair.private
    val bw1 = BufferedWriter(FileWriter("publicKey"))
    bw1.write(Base64.getEncoder().encodeToString(publicKey.encoded))
    bw1.close()
    val bw2 = BufferedWriter(FileWriter("privateKey"))
    bw2.write(Base64.getEncoder().encodeToString(privateKey.encoded))
    bw2.close()
    println("请输入您要加密的内容:")
    val input = readLine()!!
    println("私钥加密请输1 公钥加密请输2")
    when (readLine()) {
        "1" -> {
            val bw3 = BufferedWriter(FileWriter("encryptByPrivateKey"))
            bw3.write(RSACrypt.encryptByPrivateKey(input, privateKey))
            bw3.close()
        }
        "2" -> {
            val bw4 = BufferedWriter(FileWriter("encryptByPublicKey"))
            bw4.write(RSACrypt.encryptByPublicKey(input, publicKey))
            bw4.close()
        }
    }
    println("加密完成\n")
}

fun rsaDE() {
    val kf = KeyFactory.getInstance("RSA")
    println("私钥解密请输1 公钥解密请输2")
    when (readLine()) {
        "1" -> {
            val input = BufferedReader(FileReader("encryptByPublicKey")).readLine()
            val privateKey = kf.generatePrivate(
                PKCS8EncodedKeySpec(
                    Base64.getDecoder()
                        .decode(BufferedReader(FileReader("privateKey")).readLine())
                )
            )
            println("RSA解密：" + RSACrypt.decryptByPrivateKey(input, privateKey) + "\n解密完成\n")
        }
        "2" -> {
            val input = BufferedReader(FileReader("encryptByPrivateKey")).readLine()
            val publicKey = kf.generatePublic(
                X509EncodedKeySpec(
                    Base64.getDecoder()
                        .decode(BufferedReader(FileReader("publicKey")).readLine())
                )
            )
            println("RSA解密：" + RSACrypt.decryptByPublicKey(input, publicKey) + "\n解密完成\n")
        }
    }
}

fun main() {
    while (true) {
        println("请选择加密算法  DES输1  AES输2  RSA输3   查看说明输4")
        when (readLine()) {
            "1" -> {
                println("加密请输1  解密请输2")
                when (readLine()) {
                    "1" -> desEN()
                    "2" -> desDE()
                }
            }
            "2" -> {
                println("加密请输1  解密请输2")
                when (readLine()) {
                    "1" -> aesEN()
                    "2" -> aesDE()
                }
            }
            "3" -> {
                println("加密请输1  解密请输2")
                when (readLine()) {
                    "1" -> rsaEN()
                    "2" -> rsaDE()
                }
            }
            "4" -> help()
        }
    }
}

fun help() {
    """
        |本程序
    """.trimMargin().also(::println)
}