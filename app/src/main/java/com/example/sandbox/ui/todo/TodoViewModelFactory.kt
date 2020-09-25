package com.example.sandbox.ui.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sandbox.data.repositories.NotesRepository

@Suppress("UNCHECKED_CAST")
class TodoViewModelFactory(
    private val repository: NotesRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TodoViewModel(repository) as T
    }
}