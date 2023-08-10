package com.notes.notes.data.local.roomDb.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.notes.notes.data.local.roomDb.entity.Note

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note)

    @Query("Select * from notes_master")
    fun getAllNotes() : LiveData<MutableList<Note>>

    @Query("Select * from notes_master where id == :id")
    fun getNoteRecord(id : Int) : LiveData<Note>
}
