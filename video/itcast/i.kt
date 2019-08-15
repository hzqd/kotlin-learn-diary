package itcast

sealed class NedStark { //type
    class RobStark : NedStark()
    class SansaStark : NedStark()
    class AryaStark : NedStark()
    class BrandonStark : NedStark()
}

class JonSnow : NedStark()

fun hasRight(stark: NedStark) =
    when (stark) {
        is NedStark.RobStark -> true
        is NedStark.SansaStark -> true
        is NedStark.AryaStark -> true
        is NedStark.BrandonStark -> true
        else -> false
    }

fun main() {
    hasRight(NedStark.RobStark()).let(::println)
    hasRight(JonSnow()).also(::println)

    val (title, desc, imgPath, content) = News("标题", "简介", "路径", "内容")
    (title + desc + imgPath + content).let(::println)
}

data class News(var title: String, var desc: String, var imgPath: String, var content: String)//data