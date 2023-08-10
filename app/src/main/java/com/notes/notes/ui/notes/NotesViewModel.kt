package com.notes.notes.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.notes.notes.data.repository.NotesRepository
import com.notes.notes.data.local.roomDb.entity.Note

class NotesViewModel : ViewModel() {

    private val notesRepo : NotesRepository = NotesRepository()

    fun notesLiveData() : LiveData<MutableList<Note>> {
        return notesRepo.getNotesRecord();
    }
}