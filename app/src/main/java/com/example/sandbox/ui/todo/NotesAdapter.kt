package com.example.sandbox.ui.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sandbox.R
import com.example.sandbox.data.db.entities.Note

class NotesAdapter(var notes: List<Note>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView = view.findViewById(R.id.tv_note_item_title)
        var tvText: TextView = view.findViewById(R.id.tv_note_item_text)
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
        holder.tvTitle.setText(notes[position].title)
        holder.tvText.setText(notes[position].text)
    }

}