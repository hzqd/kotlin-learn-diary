/*继承，多态，接口と抽象类：
    继承 ——> open & override
    多态：同种功能，不同的表现形态。
    接口是事物的能力。
    抽象类是事物的本质。
 */
fun main(args: Array<String>) {
    var person1 = Man("工藤新一")
    var person2 = Woman("灰原哀")
    var person3 = Man("Incubator")
    var person4 = Woman("まとか")
    var person5 = Man("小华华")
//请各位大佬进集合：
    var house   = listOf<Human>(person1,person2,person3,person4,person5)
    for (a in house){
        a.eat()
        a.pee()
    }
}