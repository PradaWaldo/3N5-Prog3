package org.pradavelasque

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.util.Arrays

fun main(args : Array<String>) {

    //Obtenir le code du website
    val url : String = args[0]
    var doc : Document = Jsoup.connect(url).get()
    println(doc)

    //Extraire les balises <a> et leur attribut href
    var textWeb : String = doc.toString()
    var listDoc : List<String> = textWeb.split("\n")

    //print(listDoc.size)

    var textMu : MutableList<String> = mutableListOf()

    var cpt : Int = 0
    for (item : String in listDoc){
        textMu.add("$cpt  $item\n")
        cpt++
    }
    println(textMu)




    //Enlever les spaces au début
    /*var exemple : String = "       Allo mon ami"
    var exempleSansEspace = exemple.trimStart()
    println(exemple + "\n")
    println(exempleSansEspace)*/





}
