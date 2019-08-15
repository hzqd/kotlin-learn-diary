package itcast

@DslMarker
annotation class MYTAG

@MYTAG
open class Tag(var name: String) {
    private val list = ArrayList<Tag>()
    fun setTag(tag: Tag) = list.add(tag)
    override fun toString() = run {
        val sb = StringBuilder()
        sb.append("<$name>")
        list.forEach { sb.append(it) }
        sb.append("</$name>")
        sb.toString()
    }
}

class Div : Tag("div")
class Body : Tag("body")
class Head : Tag("head")
class Html : Tag("html")

fun html(block: Html.() -> Unit) = Html().apply(block)
fun Html.head(block: () -> Unit) = Head().let(::setTag)
fun Html.body(block: Body.() -> Unit) = Body().apply(block).let(::setTag)
fun Body.div(block: () -> Unit) = Div().let(::setTag)

fun main() {
    html {
        head {}
        body {
            div {}
        }
    }.let(::println)
}