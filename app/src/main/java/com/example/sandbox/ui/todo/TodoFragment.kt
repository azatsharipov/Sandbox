package com.example.sandbox.ui.todo

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.sandbox.R
import com.example.sandbox.data.db.NotesDatabase
import com.example.sandbox.data.db.entities.Note
import com.example.sandbox.data.repositories.NotesRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton


class TodoFragment : Fragment() {
    lateinit var notesAdapter: NotesAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var fabDel: FloatingActionButton
    lateinit var fabAdd: FloatingActionButton

    private lateinit var viewModel: TodoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.todo_fragment, container, false)

        val database = NotesDatabase(activity as Context)
        val repository = NotesRepository(database)
        val factory = TodoViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(TodoViewModel::class.java)

        recyclerView = view.findViewById(R.id.rv_todo)
        fabDel = view.findViewById(R.id.fab_todo_del)
        fabAdd = view.findViewById(R.id.fab_todo_add)

        showNotes(ArrayList<Note>())
        viewModel.getAll().observe(this, Observer {
            notesAdapter.notes = it
            notesAdapter.notifyDataSetChanged()
        })

        fabDel.setOnClickListener{
            notesAdapter.selectedNotes.forEach{
                viewModel.delete(it)
            }
            notesAdapter.selectedNotes.clear()
        }

        fabAdd.setOnClickListener{
            viewModel.insert(
                Note(
                    "New Title ${notesAdapter.notes.size}",
                    "New Text"
                )
            )
//            viewModel.update(Note("New Title", "New Text"))
        }

        return view
    }

    fun showNotes(notes: ArrayList<Note>) {
        notesAdapter = NotesAdapter(notes)
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = notesAdapter
        }
    }

}
