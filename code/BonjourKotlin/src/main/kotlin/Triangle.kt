package org.pradavelasque

fun main(){
    println("Donner la hauteur du triangle")
    val hauteurTriangle: Int = readLine()!!.toInt()
    val triangle: String = "*"

    for (i in 1 .. hauteurTriangle ){
        println("*".repeat(i))
    }

}