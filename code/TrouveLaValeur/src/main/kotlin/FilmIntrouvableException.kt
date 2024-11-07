package org.pradavelasque

class FilmIntrouvableException : Exception() {
    override val message: String?
        get() = "Le film est introuvable dans notre magasin"
}