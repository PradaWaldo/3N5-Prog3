package org.pradavelasque

fun main() {
    println("Hello World!")
    trouveru(arrayOf("Hobbit","Watchman","Spiderman"))
}

fun trouveru(valeur : Array<String>){
    var films : Array<String> = arrayOf("Hobbit", "Father", "Venom", "Joker","Batman", "Watchman");

    //Chercher la valeur dans le tableau movies
    for (film in valeur){
        if (films.contains(film)){
            val index = films.indexOf(film)

            println("Nous avons trouvé votre film $film son numéro est $index")
        }
        else{
            println("Votre film est introuvable")
        }
    }


}