package com.notes.notes.ui.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.notes.notes.R
import com.notes.notes.databinding.ActivityNotesBinding
import com.notes.notes.data.local.roomDb.entity.Note
import com.notes.notes.ui.addOrEditNote.AddOrEditNoteActivity
import com.notes.notes.ui.notes.adapters.NotesActivityAdapter

class NotesActivity : AppCompatActivity() {

    private lateinit var mBinding                   : ActivityNotesBinding
    private lateinit var mNotesViewModel            : NotesViewModel
    private lateinit var mNotesActivityAdapter      : NotesActivityAdapter
    private lateinit var mNotesList                 : MutableList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar)
        mBinding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        init()

        setNotesRvAdapter()

        mNotesViewModel.notesLiveData().observe(this){
            it?.let {
                mNotesList.clear()
                mNotesList.addAll(it)
                mNotesActivityAdapter.notifyDataSetChanged()
            }
        }

        mBinding.iBtnAddAddNote.setOnClickListener{
            startActivity(Intent(this, AddOrEditNoteActivity::class.java))
        }
    }


    //Function ot initialize variables and objects
    private fun init(){
        mNotesViewModel = NotesViewModel()
        mNotesViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        mNotesList = mutableListOf()
    }


    //Function to set notes Adapter
    private fun setNotesRvAdapter() {
        mNotesActivityAdapter = NotesActivityAdapter(this, mNotesList)
        mBinding.rvNotes.adapter = mNotesActivityAdapter
    }
}