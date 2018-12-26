fun main(args: Array<String>) {
    /**获取单个字符*/
    val c: Char = 'a'           //获取字符ascii编码
    val value: Int = c.toInt()  //字符转成十进制
    println(value)              //结果应为：97
    /**获取字符串*/
    val str = "I love you!"
    val array = str.toCharArray()//把str转成字符数组
    val result = with(StringBuilder()) {
        for (ch in array) append(ch.toInt().toString() + " ")
        toString()
    }
    println(result)
}