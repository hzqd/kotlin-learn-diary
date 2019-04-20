fun main(args: Array<String>) {
    /**单个字符*/
    println('a'.toInt())
    /**字符串*/
    val str = "I love you!"
    val array = str.toCharArray()
    with(StringBuilder()) { for (ch in array) append(ch.toInt().toString() + " ");toString() }.let(::println)
    str.toCharArray().map { it.toInt() }.joinToString(" ").let(::println)
    /**ASCIIS转String*/
    val ascii = "32534 31243 19990 30028 65281"
    val char = ascii.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    for (asc in char.indices) { print(Integer.parseInt(char[asc]).toChar()) }
    val z = "73 32 108 111 118 101 32 121 111 117 33"
    z.split(" ").map { it.toInt().toChar() }.joinToString("").also(::println)
}
