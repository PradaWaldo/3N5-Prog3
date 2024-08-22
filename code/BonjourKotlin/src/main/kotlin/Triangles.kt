package org.pradavelasque

fun triangle(hauteur : Int) : String {
    val sb = StringBuilder()

    // Construction du triangle ligne par ligne
    for (i in 1..hauteur) {
        // Ajouter les espaces avant les astérisques
        sb.append(" ".repeat(hauteur - i))
        // Ajouter les astérisques pour la ligne actuelle
        sb.append("*".repeat(i * 2 - 1))
        // Ajouter un saut de ligne après chaque ligne du triangle
        sb.append("\n")
    }

    // Retourner le triangle construit sous forme de String
    return sb.toString()
}


fun main() {
    val hauteurs = listOf(3, 5, 7, 4, 6)
    hauteurs.forEachIndexed { index, hauteur ->
        println("Triangle ${index + 1} (hauteur $hauteur):")
        println(triangle(hauteur))
        println()

    }
}