package org.pradavelasque

import java.io.File

fun main(args: Array<String>){

    var nomFichier : File = File(args[0])
    var nomPersonne = args[1]
    var prenomPersonne = args[2]



    if (nomFichier.exists()){
        try {
            var textFile : String = nomFichier.readText()
            println(textFile)
            var listText : List<String> = textFile.split("\n")
            println(listText)

            var newText : String = listText.joinToString("-------------")
            println(newText)

            var newFile : File = File("PradaWaldomar.txt")
            newFile.writeText("Mon nom est $nomPersonne $prenomPersonne")

        } catch (e: Exception) {
            println("Le fichier $nomFichier ne peut pas etre lu")
        }
    }
    else{
        println("Le fichier $nomFichier n'existe pas")
    }



}