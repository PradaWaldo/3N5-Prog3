package org.pradavelasque

fun main(args : Array<String>){

    var hauteurPyramide: Int = args[0].toInt()
    var etoile: String = "*"
    var espace : String =  " "
    var nbrEtoile : Int = 1
    var nbrEspace : Int = hauteurPyramide

    pyramid(hauteurPyramide, espace, nbrEspace, etoile, nbrEtoile)

}

private fun pyramid(
    hauteurPyramide: Int,
    espace: String,
    nbrEspace: Int,
    etoile: String,
    nbrEtoile: Int
) {
    var nbrEspace1 = nbrEspace
    var nbrEtoile1 = nbrEtoile
    for (i in 0..hauteurPyramide) {

        println(espace.repeat(nbrEspace1) + etoile.repeat(nbrEtoile1))
        nbrEtoile1 += 2
        nbrEspace1 -= 1

    }
}