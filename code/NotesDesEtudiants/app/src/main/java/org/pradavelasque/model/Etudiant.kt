package org.pradavelasque.model

data class Etudiant (
    val id: Int,
    val nom: String,
    val prenom: String,
    val age: Int
) {
    override fun toString(): String {
        return "$nom $prenom"
    }
}