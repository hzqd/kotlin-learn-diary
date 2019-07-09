package itcast

import kotlin.reflect.KProperty

class BigHeadSon1 {
    var 压岁钱: Int by Mother()
}

class Mother {
    var 儿子的压岁钱 = 0
    var 自己的小金库 = 0
    //儿子要压岁钱
    operator fun getValue(bigHeadSon1: BigHeadSon1, property: KProperty<*>): Int {
        return 儿子的压岁钱
    }

    //儿子存压岁钱
    operator fun setValue(bigHeadSon1: BigHeadSon1, property: KProperty<*>, i: Int) {
        儿子的压岁钱 += 50
        自己的小金库 += i - 50
    }
}

fun main() {
    val bigHeadSon = BigHeadSon1()
    bigHeadSon.压岁钱 = 100
    bigHeadSon.压岁钱.let(::println)
}