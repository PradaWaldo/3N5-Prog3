package org.pradavelasque

import java.io.File

fun main(args: Array<String>){
    var nomFichier = args[0]
    var nomPersonne = args[1]
    var prenomPersonne = args[2]

    var fichier : File = File(nomFichier)

    if (fichier.exists()){
        var textRead: String = fichier.readText()
        var textFichier: List<String> = textRead.split("\n")
        var newTexte1: String = textFichier.joinToString("\n---------------------\n")

        fichier.writeText(newTexte1)
        println(textRead)
    }



}