fun main(){
    val transacciones : List<Double?> = listOf(242.53, 939.4939, null, 393.8930, -800.49)
	val total : Double = totalTransaccion(transacciones)
    println("El balance es $total")
}

fun totalTransaccion(transaccionesParam: List<Double?>): Double{
    var total: Double=0.0
    for (transaccion in transaccionesParam){
        var parcial = transaccion ?: 0.0
        total=total + parcial
    }
    return total
}