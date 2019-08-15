package itcast

enum class WEEK {
    星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日
}

fun todo(week: WEEK) =
    when (week) {
        in WEEK.星期一..WEEK.星期五 -> "上班"
        else -> "休息"
    }

fun main() {
    todo(WEEK.星期三).let(::println)
    todo(WEEK.星期六).let(::println)

    (COLOR.RED.r + COLOR.GREEN.g == COLOR.BLUE.b * 2).also(::println)
}

enum class COLOR(var r: Int, var g: Int, var b: Int) {
    RED(255, 0, 0), GREEN(0, 255, 0), BLUE(0, 0, 255)
}