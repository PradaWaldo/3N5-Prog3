package org.pradavelasque
import org.jsoup.Jsoup
import java.io.IOException

fun main(args: Array<String>) {
    // Vérifie si une URL est passée en argument
    if (args.isNotEmpty()) {
        val url = args[0]
        try {
            // Utilise Jsoup pour récupérer le contenu de la page à l'URL donnée
            val document = Jsoup.connect(url).get()

            // Affiche le contenu HTML de la page
            println("Contenu HTML de la page :")
            println(document.outerHtml())

        } catch (e: IOException) {
            println("Erreur lors de la récupération de la page : ${e.message}")
        }
    } else {
        println("Veuillez fournir une URL en argument.")
    }
}
