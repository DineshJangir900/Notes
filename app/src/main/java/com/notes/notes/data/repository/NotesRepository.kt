package com.notes.notes.data.repository

import androidx.lifecycle.LiveData
import com.notes.notes.NotesApplication
import com.notes.notes.data.local.roomDb.entity.Note

class NotesRepository {
    private val mRoomDb = NotesApplication.getRoomDb()

    //Function to get All Notes
    fun getNotesRecord(): LiveData<MutableList<Note>> {
        return mRoomDb.noteDao().getAllNotes()
    }

    //Function to get Single Note Data
    fun getNoteRecord(id: Int): LiveData<Note> {
        return mRoomDb.noteDao().getNoteRecord(id)
    }

    //Function to save note
    fun saveNote(note: Note) {
        mRoomDb.noteDao().insertNote(note)
    }
}