package com.notes.notes.ui.addOrEditNote

import androidx.lifecycle.ViewModel
import com.notes.notes.data.local.roomDb.entity.Note
import com.notes.notes.data.repository.NotesRepository

class AddOrEditNoteViewModel : ViewModel() {

    private val notesRepo = NotesRepository()

    fun getNoteRecord(id: Int) = notesRepo.getNoteRecord(id)

    fun saveNote(note: Note) = notesRepo.saveNote(note)
}