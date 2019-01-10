//凯撒加密算法：
class CaesarCrypt {
    /**
     * 加密：
     * @param input 原文
     * @param key 秘钥
     */
    fun encrypt(input: String, key: Int): String {
        val charArray = input.toCharArray()
        return with(StringBuilder()) {
            charArray.forEach {
                //遍历每一个字符,对ascii偏移
                val c = it
                //获取ascii
                var ascii = c.toInt()
                //移动：
                ascii += key
                //转成字符：
                val result = ascii.toChar()
                append(result)
            }
            //返回结果：
            toString()
        }
    }

    /**解密：
     * @param input 加密的密文
     * @param key 秘钥
     */
    fun decrypt(input: String, key: Int): String {
        val charArray = input.toCharArray()
        return with(StringBuilder()) {
            charArray.forEach {
                //遍历每一个字符,对ascii偏移
                val c = it
                //获取ascii
                var ascii = c.toInt()
                //反向移动：
                ascii -= key
                //转成字符：
                val result = ascii.toChar()
                append(result)
            }
            //返回结果：
            toString()
        }
    }
}

fun main(args: Array<String>) {
//    val asc = 'A'.toInt() + 1
//    asc.toChar().also(::println)
//    /**示例：*/
//    val command = "I love you!"
//    val key = 2
//    val charArray = command.toCharArray()
//    charArray.forEach {
//        //遍历每一个字符,对ascii偏移
//        val c = it
//        //获取ascii
//        var ascii = c.toInt()
//        //移动：
//        ascii += key
//        //转成字符：
//        ascii.toChar().let(::println)
//    }
    val command = "I love you!"
    val key = 2
    val encrypt = CaesarCrypt().encrypt(command, key)
    println(encrypt)
    CaesarCrypt().decrypt(encrypt, key).let(::println)
}