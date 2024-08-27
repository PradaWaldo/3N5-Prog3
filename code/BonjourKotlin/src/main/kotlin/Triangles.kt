package org.pradavelasque

fun main() {
    println("Donner la hauteur du triangle")
    val triangle: Int = readLine()!!.toInt()

    println(triangles(triangle))
    println(triangles(triangle))
    println(triangles(triangle))
    println(triangles(triangle))
    println(triangles(triangle))
}

fun triangles(hauteur: Int) : String {


    var nbrT = ""
    for (i in 1 .. hauteur ) {
         nbrT += "*".repeat(i)+ "\n"
    }
    return nbrT
}