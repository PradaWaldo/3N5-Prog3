package org.pradavelasque

fun main(){
    println("Veuillez entrer un nombre:")

    var motTapper : String = readln()
    var reussi : Int = 0


    while (true) {
        try {
            var nombreDemande : Int = motTapper.toInt()
            reussi = 1
        }
        catch (e: Exception){
            reussi = 0
        }

        if (reussi == 1) {
            var nombreDemande : Int = motTapper.toInt()
            println("Merci, votre nombre est $nombreDemande")
            return
        }
        else{
            println("Ceci n'est pas un nombre, veillez entrer un nombre:")
            motTapper = readln()
        }

    }


}