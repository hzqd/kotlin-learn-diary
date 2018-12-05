//非诚勿扰的舞台：
fun main(args: Array<String>) {
//传统方法实现需求的缺点：
    filterGirlsByAddress("广东")
    println("")
    filterGirlsByAge(30)
    println("")
    filterGirlsByAddressHeightAge("广东",165,25,true)
    filterGirlsByAddressHeightAge("广东",165,25,false)
    println("")
//高阶函数：
    println(非诚勿扰数据库.maxBy { it.height })
    println(非诚勿扰数据库.minBy { it.age })
    println(非诚勿扰数据库.find { it.age==19 })
    println(非诚勿扰数据库.map { "${it.name} : ${it.address}" })
    println(非诚勿扰数据库.groupBy { it.address })
    println(非诚勿扰数据库.any { it.age==18 })
    println(非诚勿扰数据库.count { (it.age<25) and (it.address=="广东") })
    println("")
//领域特定语言DSL：
    非诚勿扰数据库 查找嫩妹子年龄小于 20
    println("")
    非诚勿扰数据库 查找嫩妹子年龄大于 30
    println("")
    非诚勿扰数据库 查找妹子来自 "山东"
}