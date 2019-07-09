package itcast

interface WashPower {
    fun wash()
}

class BigHeadSon : WashPower {
    override fun wash() {
        println("start wash")
    }
}

//class SmallHeadFather:WashPower by BigHeadSon()
class SmallHeadFather(private val washPerson: WashPower) : WashPower by washPerson {
    override fun wash() {
        println("pay money.")
        washPerson.wash()
        println("good job!")
    }
}

fun main() {
    val bigHeadSon = BigHeadSon()
    val smallHeadFather = SmallHeadFather(bigHeadSon)
    smallHeadFather.wash()
}