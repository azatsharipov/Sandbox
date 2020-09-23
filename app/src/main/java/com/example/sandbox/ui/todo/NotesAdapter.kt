package com.example.sandbox.ui.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sandbox.R
import com.example.sandbox.models.Note

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    lateinit var notes: ArrayList<Note>

    class NotesViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        init {
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false) as View
        return NotesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
    }

}