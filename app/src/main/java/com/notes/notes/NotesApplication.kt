package com.notes.notes

import android.app.Application
import androidx.room.Room
import com.notes.notes.data.local.roomDb.NotesDatabase

class NotesApplication : Application() {

    companion object{
        private lateinit var notesDatabase: NotesDatabase

        fun getRoomDb() = notesDatabase
    }

    override fun onCreate() {
        super.onCreate()

        notesDatabase = Room
            .databaseBuilder(this, NotesDatabase::class.java, "notes_db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }
}