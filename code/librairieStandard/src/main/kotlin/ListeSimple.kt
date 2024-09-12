package org.pradavelasque

fun main() {
var liste1 : List<Int> = repete(4,2)
    println(liste1)
}

fun repete(n : Int, nombreFois : Int): List<Int> {
var liste = mutableListOf<Int>()
    for (i in 1..n) {
        repeat(nombreFois) {
            liste.add(i)
        }
    }
    return liste
}
