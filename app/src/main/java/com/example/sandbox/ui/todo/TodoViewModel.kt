package com.example.sandbox.ui.todo

import androidx.lifecycle.ViewModel
import com.example.sandbox.data.db.entities.Note
import com.example.sandbox.data.repositories.NotesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: NotesRepository) : ViewModel() {
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
