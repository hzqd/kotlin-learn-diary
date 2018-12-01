fun main(args: Array<String>) {
    loop@ for(i in 0..5){
        loop2@ for(j in 6..10){
            println(""+i+" and "+j)
            if (i == 5) {
                println("loop break")
                break@loop
            }
            if (j == 9) {
                println("loop2 continue")
                continue@loop2
            }
            if ((i==0) and (j==7)) {
                println("loop continue")
                continue@loop
            }

        }
    }
}