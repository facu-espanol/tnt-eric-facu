import kotlin.math.*
fun main(){
    println("El numero 32 es par? "+32.esPar())
    println("El numero 31 es par? "+31.esPar())
	println("El numero 3 es primo? "+3.esPrimo())
	println("El numero 2 es primo? "+2.esPrimo())
    println("El numero 14 es primo? "+14.esPrimo())
    println("El numero 7 es primo? "+7.esPrimo())
    println("El numero 1 es primo? "+1.esPrimo())


}

fun Int.esPar(): Boolean{
    return (this%2==0)
}

fun Int.esPrimo(): Boolean{
    if (this==1){
        return false
    }
    val raizTemporal = sqrt(this.toDouble())
    val raiz=raizTemporal.toInt()
    var i = 2
    while (i<=raiz){
        if (this%i==0){
            return false
        }
        i++;
    }
    return true;
}