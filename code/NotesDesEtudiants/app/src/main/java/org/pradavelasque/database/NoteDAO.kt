package org.pradavelasque.database

import org.pradavelasque.model.Note

class NoteDAO {
    fun lister(): List<Note> {
        return listOf(
            Note(1, "Note 1", "Contenu de la note 1"),
            Note(2, "Note 2", "Contenu de la note 2"),
            Note(3, "Note 3", "Contenu de la note 3")
        )
    }

    fun ajouter(note: Note) {
        println("Ajout de la note: $note")
    }

    fun modifier(note: Note) {
        println("Modification de la note: $note")
    }

    fun supprimer(note: Note) {
        println("Suppression de la note: $note")
    }

    fun obtenir(id: Int): Note {
        return Note(id, "Note $id", "Contenu de la note $id")
    }
}
