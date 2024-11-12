package org.pradavelasque.database

import android.content.Context
import androidx.room.Room

object UtilitaireBD {
    fun get(ctx: Context): EtudiantDataBase {
        return Room.databaseBuilder(
            ctx,
            EtudiantDataBase::class.java, "etudiant-db"
        ).build()
    }
}