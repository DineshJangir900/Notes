package com.notes.notes.data.local.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.notes.notes.data.local.roomDb.dao.NoteDao
import com.notes.notes.data.local.roomDb.entity.Note

@Database(entities = [Note::class], version = 3)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}

