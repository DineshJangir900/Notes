package com.notes.notes.data.local.roomDb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_master")
data class Note(
    val noteTitle : String,
    val note : String,
    val created_at : Long,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)
