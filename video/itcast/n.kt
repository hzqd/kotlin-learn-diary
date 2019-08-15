package itcast

data class Student(
    var name: String? = null,
    var age: Byte? = null,
    var id: Long? = null,
    var gender: String? = null,
    var score: Score? = null
)
data class Score(var Chinese: Byte? = null, var Math: Byte? = null, var English: Byte? = null)
fun student(block: Student.() -> Unit) = Student().apply(block)
fun Student.score(block: Score.() -> Unit) = run { score = Score().apply(block) }
fun main() {
    student {
        name = "hzq"
        age = 20
        id = 2018125207
        gender = "male"
        score {
            Chinese = 80
            Math = 30
            English = 90
        }
    }.let(::println)
}