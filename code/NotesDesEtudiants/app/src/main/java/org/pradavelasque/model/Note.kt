package org.pradavelasque.model

data class Note (
    val id: Int,
    val titre: String,
    val note: Int
) {
    override fun toString(): String {
        return titre
    }
}