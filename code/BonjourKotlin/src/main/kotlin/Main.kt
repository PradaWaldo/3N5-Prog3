package org.pradavelasque

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        val nom = args[0]
        affichergf(nom)
    } else {
        println("*")
    }
}

fun affichergf(nom: String) {
    println("Bonjour $nom!")
}