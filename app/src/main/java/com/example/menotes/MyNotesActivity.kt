package com.example.menotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyNotesActivity : AppCompatActivity() {

    private val notes = mutableListOf(
        Note("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin orci lacus, vestibulum non dictum ut, tempus et nibh. Aenean sollicitudin sapien sit amet leo tempus, quis volutpat leo pellentesque. Morbi ut ligula ac nisi condimentum scelerisque. Donec id ligula turpis. Fusce tristique euismod bibendum. Suspendisse eu consequat mauris, in scelerisque elit. Nam quis aliquet erat, ac molestie odio. Curabitur rhoncus augue eros, nec finibus enim accumsan nec. Donec dolor enim, viverra in pharetra a, imperdiet id nunc. Etiam lacinia odio mollis ultricies finibus. In consequat quam ac tortor sollicitudin interdum. Vestibulum gravida lacus ac odio posuere, at aliquet mauris ullamcorper."),
        Note("Lorem ipsum dolor sit amet, consectetur adipiscing elit."),
        Note("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin orci lacus, vestibulum non dictum ut, tempus et nibh.")
    )

    private lateinit var rvNotes: RecyclerView
    private lateinit var notesAdapter: NotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_notes)
        initComponent()
        initUI()

        val addButton = findViewById<FloatingActionButton>(R.id.add_btt)

        addButton.setOnClickListener {
            val intent = Intent(this, NewNoteActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initComponent() {
        rvNotes = findViewById(R.id.rvNotes)
    }

    private fun initUI() {
        notesAdapter = NotesAdapter(notes)
        rvNotes.layoutManager = LinearLayoutManager(this)
        rvNotes.adapter = notesAdapter
    }
}