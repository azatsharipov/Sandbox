package com.example.sandbox.ui.todo.note

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.sandbox.R
import com.example.sandbox.data.db.NotesDatabase
import com.example.sandbox.data.db.entities.Note
import com.example.sandbox.data.repositories.NotesRepository
import com.example.sandbox.ui.todo.NoteViewModelFactory


class NoteFragment : Fragment() {

    lateinit var etTitle: EditText
    lateinit var etText: EditText
    lateinit var note: Note
    lateinit var alertDialog: AlertDialog

    private lateinit var viewModel: NoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.note_fragment, container, false)

        val database = NotesDatabase(activity as Context)
        val repository = NotesRepository(database)
        val factory = NoteViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(NoteViewModel::class.java)

        etTitle = view.findViewById(R.id.et_note_title)
        etText = view.findViewById(R.id.et_note_text)

        note = arguments?.getSerializable("note") as Note
        etTitle.setText(note.title)
        etText.setText(note.text)

        val onEdited: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun afterTextChanged(editable: Editable) {
                updateNote()
            }
        }

        etTitle.addTextChangedListener(onEdited)
        etText.addTextChangedListener(onEdited)

        setHasOptionsMenu(true);

        alertDialog = AlertDialog.Builder(activity)
            .setTitle("Delete Note")
            .setMessage("Do you want to delete this note?")
            .setPositiveButton("Yes") { _, _ ->
                deleteNote()
            }
            .setNegativeButton("No") { _, _ ->

            }.create()

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.note_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mDelete -> alertDialog.show()
        }
        return super.onOptionsItemSelected(item)
    }

    fun updateNote() {
        note.title = etTitle.text.toString()
        note.text = etText.text.toString()
        viewModel.update(note)
    }

    fun deleteNote() {
        note.title = etTitle.text.toString()
        note.text = etText.text.toString()
        viewModel.delete(note)
        findNavController().navigateUp()
    }

}
