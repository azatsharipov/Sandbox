package com.example.sandbox.ui.todo.note

import androidx.lifecycle.ViewModel
import com.example.sandbox.data.db.entities.Note
import com.example.sandbox.data.repositories.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NotesRepository) : ViewModel() {
    fun insert(note: Note) {
        CoroutineScope(Dispatchers.Main).launch {
            repository.insert(note)
        }
    }

    fun update(note: Note) {
        CoroutineScope(Dispatchers.Main).launch {
            repository.update(note)
        }
    }

    fun delete(note: Note) {
        CoroutineScope(Dispatchers.Main).launch {
            repository.delete(note)
        }
    }

    fun getAll() = repository.getAll()
}
