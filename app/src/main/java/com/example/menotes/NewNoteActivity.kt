package com.example.menotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NewNoteActivity : AppCompatActivity() {
    private lateinit var editTextNote: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_note)

        editTextNote = findViewById(R.id.etNote)

        val saveButton = findViewById<FloatingActionButton>(R.id.save_btt)

        saveButton.setOnClickListener {
            val note = editTextNote.text.toString()

            if (note.isNotEmpty()) {
                val intent = Intent(this, MyNotesActivity::class.java)

                startActivity(intent)
            }
        }
    }
}