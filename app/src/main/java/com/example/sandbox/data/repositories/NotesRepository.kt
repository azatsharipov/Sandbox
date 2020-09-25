package com.example.sandbox.data.repositories

import com.example.sandbox.data.db.NotesDatabase
import com.example.sandbox.data.db.entities.Note

class NotesRepository(private val db: NotesDatabase) {
    suspend fun insert(note: Note) = db.getNotesDao().insert(note)

    suspend fun update(note: Note) = db.getNotesDao().update(note)

    suspend fun delete(note: Note) = db.getNotesDao().delete(note)

    fun getAll() = db.getNotesDao().getAll()
}