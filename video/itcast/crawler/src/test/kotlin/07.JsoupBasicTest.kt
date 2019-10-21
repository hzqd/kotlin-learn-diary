import org.apache.commons.io.FileUtils import org.jsoup.Jsoup import java.io.File import java.net.URL

fun testUrl() {
    Jsoup.parse(URL("http://www.itcast.cn"), 1000)
        .getElementsByTag("title").first().text().sout()
}

const val path = "D:\\OLD\\allOtherItem\\crawler\\src\\test\\resources\\bili"
fun testString() {
    FileUtils.readFileToString(File(path), "utf-8").let {
        Jsoup.parse(it)
    }.getElementsByTag("title").first().text().sout()
}

fun testFile() {
    Jsoup.parse(File(path), "utf-8")
        .getElementsByTag("title").first().text().sout()
}

fun testDOM() {
    Jsoup.parse(File(path), "utf-8")
        .getElementsByTag("span").first().text().sout()
    Jsoup.parse(File(path), "utf-8")
        .getElementsByClass("t").first().text().sout()
    Jsoup.parse(File(path), "utf-8")
        .getElementsByAttributeValue("href", "//game.bilibili.com").first().text().sout()
}

fun testData() {
    Jsoup.parse(File(path), "utf-8").getElementById("header-mobile-app")
        .apply { id().sout() }
        .apply { className().sout() }
        .apply { attr("title").sout() }
        .apply { attributes().sout() }
        .apply { text().sout() }
}

fun testSelector() {
    Jsoup.parse(File(path), "utf-8")
        .select("span").map { it.text() }.filter { it.isNotEmpty() }.sout()
}

fun main() {
    testUrl()
    testString()
    testFile()
    testDOM()
    testData()
    testSelector()
}