package org.pradavelasque

import kotlin.math.sign
import kotlin.random.Random

fun main(args : Array<String>){
    var tableau: Array<Int> = creeTableauAleatoire(args[0].toInt())
    println(tableau.joinToString())
}

 fun creeTableauAleatoire(n: Int): Array<Int>{
    return Array(n){
        Random.nextInt(0,100)
    }
}