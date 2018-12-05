data class girl(var name:String, var age:Int, var height:Int, var address:String)
    var 非诚勿扰数据库 = listOf<girl>(
            girl("依儿",18,168,"山东"),
            girl("笑笑",18,175,"河南"),
            girl("小百合",17,155,"福建"),
            girl("Michel",22,148,"广东"),
            girl("猫咪",28,159,"广西"),
            girl("玲儿",23,169,"广东"),
            girl("环环",25,172,"安徽"),
            girl("胖嘟嘟",32,180,"河北"),
            girl("乔乔",35,180,"广东"),
            girl("小可爱",27,150,"江西"),
            girl("一生有你",22,163,"山东"),
            girl("敏儿",28,155,"黑龙江"),
            girl("月儿",25,178,"吉林"),
            girl("花儿",21,183,"山东"),
            girl("S小糖",49,190,"新疆"),
            girl("悦悦",19,160,"广西"),
            girl("小可爱",29,158,"广东"),
            girl("紫琪",49,149,"新疆"),
            girl("糖心",26,165,"甘肃"),
            girl("棒棒糖",23,172,"浙江"),
            girl("猪猪侠",18,173,"山东"),
            girl("喵喵",27,164,"河南"),
            girl("安琦",19,159,"河北"),
            girl("叶子",20,160,"广东")
)
fun filterGirlsByAddress(address: String){
    var 某个地区的妹子 = ArrayList<girl>()
    for(a in 非诚勿扰数据库) if(a.address==address) 某个地区的妹子.add(a)
        for(a in 某个地区的妹子) println("${a.address} ${a.age}岁的美女 ${a.name}")
}