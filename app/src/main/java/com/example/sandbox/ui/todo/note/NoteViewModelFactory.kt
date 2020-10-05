package com.example.sandbox.ui.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sandbox.data.repositories.NotesRepository
import com.example.sandbox.ui.todo.note.NoteViewModel

@Suppress("UNCHECKED_CAST")
class NoteViewModelFactory(
    private val repository: NotesRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NoteViewModel(repository) as T
    }
}