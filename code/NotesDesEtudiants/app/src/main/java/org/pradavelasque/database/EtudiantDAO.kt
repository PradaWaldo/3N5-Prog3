package org.pradavelasque.database

import org.pradavelasque.model.Etudiant
import java.util.Optional

interface EtudiantDAO {

    fun lister(): List<Etudiant>
    fun ajouter(etudiant: Etudiant)
    fun modifier(etudiant: Etudiant)
    fun supprimer(etudiant: Etudiant)
    fun obtenir(id: Int): Etudiant

    abstract fun EtudiantParNom(Nom: String): Optional<Etudiant>

}