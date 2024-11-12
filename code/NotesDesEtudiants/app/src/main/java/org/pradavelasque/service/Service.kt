package org.pradavelasque.service
import android.content.Context
import org.pradavelasque.database.EtudiantDAO
import org.pradavelasque.database.EtudiantDataBase
import org.pradavelasque.database.UtilitaireBD
import org.pradavelasque.model.Etudiant
import org.pradavelasque.model.Note
import java.util.Optional

class Service(context: Context) {

    private val database : EtudiantDataBase = UtilitaireBD.get(context)
    private val dao : EtudiantDAO = database.dao()

    fun ajouterEtudiant(note: Note){
        // validation du contenu
        if (note.note < 0){
            throw IllegalArgumentException("Note vide")
        }
        if (note.note < 100){
            throw IllegalArgumentException("Note trop haute")
        }
        val existant : Optional<Etudiant> = dao.EtudiantParNom(note.titre)
        if (existant.isPresent){
            throw IllegalArgumentException("Étudiant déjà existant")
        }
        // Tout va bien, on peut ajouter le sujet dans la BD
        val etudiant = Etudiant(note.titre)
        etudiant.contenu = contenu
        dao.ajouterEtudiant(etudiant)
    }

    fun ajouterVote(note: Note){
        // TODO à faire plus des tests JUnit
        throw UnsupportedOperationException()
    }

    fun listeEtudiant(): List<Etudiant>{
        throw UnsupportedOperationException()
    }

    fun moyenneNotes(id: Long): Double{
        throw UnsupportedOperationException()
    }

    fun distributionNotes(id: Long): Map<Int, Int>{
        throw UnsupportedOperationException()
    }

    fun supprimerTousLesEtudiants(){
        throw UnsupportedOperationException()
    }

    fun supprimerTousLesNotes(){
        throw UnsupportedOperationException()
    }

    fun etudiantParId(id: Long): Etudiant? {
        throw UnsupportedOperationException()
    }
}