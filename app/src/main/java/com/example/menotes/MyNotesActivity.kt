package com.example.menotes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyNotesActivity : AppCompatActivity() {

    private val notes = mutableListOf<Note>()

    private lateinit var rvNotes: RecyclerView
    private lateinit var notesAdapter: NotesAdapter

    private lateinit var addBtt: FloatingActionButton

    private lateinit var startForResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_notes)
        initComponent()
        initUI()
        initListeners()

        startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data: Intent? = result.data
                    val newNote = data?.getStringExtra("EXTRA_NAME_NOTE")
                    newNote?.let {
                        notes.add(Note(it))
                        updateNotes()
                    }
                }
            }
    }

    private fun initListeners() {
        addBtt.setOnClickListener {
            val intent = Intent(this, NewNoteActivity::class.java)
            startForResult.launch(intent)
        }
    }

    private fun initComponent() {
        rvNotes = findViewById(R.id.rvNotes)
        addBtt = findViewById(R.id.add_btt)
    }

    private fun initUI() {
        notesAdapter = NotesAdapter(notes)
        rvNotes.layoutManager = LinearLayoutManager(this)
        rvNotes.adapter = notesAdapter
    }

    private fun updateNotes() {
        notesAdapter.notifyDataSetChanged()
    }
}