package org.pradavelasque

fun main(){
    println("Donner la hauteur du triangle")
    val hauteurTriangle: Int = readLine()!!.toInt()

    for (i in 1 .. hauteurTriangle ){
        println("*".repeat(i))
    }

}