import arrow.core.Option
import arrow.core.extensions.list.monadFilter.filterMap
import org.junit.Assert.assertEquals

fun main() {
    assertEquals("taxi", high("man i need a taxi up to ubud"))
    assertEquals("volcano", high("what time are we climbing up the volcano"))
    assertEquals("semynak", high("take me to semynak"))
}
// condition `"" == null` is always false   // This is wrong
fun high(str: String) = str.split("").filterMap { Option.fromNullable(it) }