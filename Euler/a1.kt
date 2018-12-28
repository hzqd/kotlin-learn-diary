/**Multiples of 3 and 5
Problem 1
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.
 */
//fun main(args: Array<String>) {
//    var sum = 0
//    for (i in (1..999)) { //for (i in 1 until 1000) {
//        if (i % 3 == 0 || i % 5 == 0) {
//            sum += i
//        }
//    }
//    println(sum)
//}
//fun main(args: Array<String>) {   //可以省略asSequence
//    println((1 until 1000).asSequence().filter { it % 3 == 0 || it % 5 == 0 }.sum())
//}
fun main(args: Array<String>) {
    (1 until 1000).filter { it % 3 == 0 || it % 5 == 0 }.sum().let(::println)
}