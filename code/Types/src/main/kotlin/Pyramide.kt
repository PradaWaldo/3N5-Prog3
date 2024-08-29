package org.pradavelasque

fun main(args : Array<String>){

    var hauteurPyramide: Int = args[0].toInt()
    var etoile: String = "*"
    var espace : String =  " "

    for (i in 0..hauteurPyramide){

        println(espace.repeat(hauteurPyramide) + etoile)
        etoile += etoile.repeat(2)
        --hauteurPyramide
    }

}