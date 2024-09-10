package org.pradavelasque

fun main(args: Array<String>) {

    var nombre : Int = args[0].toInt()

    var binaire = Integer.toBinaryString(nombre)

    println("Nombre: $nombre")
    println("Binaire: $binaire")
}