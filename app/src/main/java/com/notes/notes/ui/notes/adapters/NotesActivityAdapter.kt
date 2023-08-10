package com.notes.notes.ui.notes.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.*
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.notes.notes.databinding.NoteViewBinding
import com.notes.notes.data.local.roomDb.entity.Note
import com.notes.notes.ui.addOrEditNote.AddOrEditNoteActivity
import com.notes.notes.ui.notes.adapters.NotesActivityAdapter.*
import com.notes.notes.utils.Constants
import com.notes.notes.utils.Util

class NotesActivityAdapter(private val context : Context, private val notesList : MutableList<Note>) : RecyclerView.Adapter<NoteViewHolder>() {

    class NoteViewHolder(val mBinding : NoteViewBinding) : RecyclerView.ViewHolder(mBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NoteViewHolder {
       val binding = NoteViewBinding.inflate(LayoutInflater.from(context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notesList[position]

        if(note.noteTitle.isNotEmpty()){
            holder.mBinding.tvNoteTitle.visibility = VISIBLE
            holder.mBinding.tvNoteTitle.text = note.noteTitle
        }else{
            holder.mBinding.tvNoteTitle.visibility = GONE
        }

        holder.mBinding.tvNote.text = note.note
        holder.mBinding.tvTime.text = Util.getDate(note.created_at)

        holder.itemView.setOnClickListener{
            goToEditNoteScreen(note)
        }
    }

    private fun goToEditNoteScreen(note: Note) {
        val intent = Intent(context, AddOrEditNoteActivity::class.java)
        intent.putExtra(Constants.ID, note.id)
        context.startActivity(intent)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

}