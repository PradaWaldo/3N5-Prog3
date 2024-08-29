package org.pradavelasque

fun main(args : Array<String>){

    var lettre : String = ""
    val listChar : List<Char> = args[0].toList()

    for (i in 0..listChar.count()-1){

        lettre = listChar[i].toString()

        print(lettre)

    }
}