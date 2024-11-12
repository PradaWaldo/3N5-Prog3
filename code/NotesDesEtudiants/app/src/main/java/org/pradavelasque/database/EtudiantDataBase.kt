package org.pradavelasque.database

import androidx.room.RoomDatabase

abstract class EtudiantDataBase : RoomDatabase() {

    abstract fun etudiantDAO(): EtudiantDAO
    abstract fun noteDAO(): NoteDAO
    abstract fun dao(): EtudiantDAO

}
