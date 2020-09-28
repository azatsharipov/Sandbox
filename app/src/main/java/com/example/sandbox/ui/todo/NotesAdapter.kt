package com.example.sandbox.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sandbox.R
import com.example.sandbox.data.db.entities.Note

class NotesAdapter(var notes: List<Note>) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    var selectedNotes: ArrayList<Note> = ArrayList<Note>()

    class NotesViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView = view.findViewById(R.id.tv_note_item_title)
        var tvText: TextView = view.findViewById(R.id.tv_note_item_text)
        var cb: CheckBox = view.findViewById(R.id.cb_note_item)
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
        holder.cb.isChecked = false
        holder.view.setOnClickListener{
            val navController = it.findNavController()
            val bundle = Bundle()
            bundle.putString("title", notes[position].title)
            bundle.putString("text", notes[position].text)
            bundle.putSerializable("note", notes[position])
            navController.navigate(R.id.action_todoFragment_to_noteFragment, bundle)
        }
        holder.cb.setOnClickListener{
            selectedNotes.add(notes[position])
//            holder.cb.isChecked = !holder.cb.isChecked
        }
    }

}