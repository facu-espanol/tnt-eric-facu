fun main(){
    data class Transaccion(var categoria : String, var monto : Double=0.0)
    val transacciones = listOf(
        Transaccion("comida", 150.0),
        Transaccion("comida", 80.0),
        Transaccion("transporte", 120.0),
        Transaccion("transporte", 60.0),
        Transaccion("alquiler", 300.0),
        Transaccion("alquiler", 100.0),
        Transaccion("ocio", 200.0),
        Transaccion("ocio", 50.0)
    )
	val mayores_a_cien=transacciones.filter{n->n.monto>100}
    println("Las transacciones que el monto es superior a 100 son:")
    println(mayores_a_cien)
    println("El promedio de las transacciones agrupadas por categoria:")
    val por_categoria=transacciones.groupBy{it.categoria}.mapValues{it.value.map { it.monto }.average() }
    println(por_categoria)
}