fun main(args: Array<String>) {
    var array = intArrayOf(1,1,2,3,4,4,5,5,5,5,6,7,8,8,1,1,9,9)
    var dup = ArrayList<Int>()
    for (i in 0 until array.size-1){
        for(j in i+1 until array.size){
            if (array[i]==array[j] && !(array[i] in dup)){
                println("Find duplicate: "+array[i])
                dup.add(array[i])
            }
        }
    }
}