fun main(){
    val numeros = listOf(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20)
    println(cuadrados(numeros))

}

fun cuadrados(numeros: List<Int>):List<Int>{
    return numeros.filter{n->n%3==0}.map{n->n*n}
}