fun main(){
    data class Auto(var modelo : String, var anio : Int=0, var patente: String="")
    
    val auto : Auto = Auto(modelo = "tiida").apply {
        anio = 2014
        patente = "oxf 390"
    }
    
    println(auto)
}