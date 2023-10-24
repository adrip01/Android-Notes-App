package com.example.menotes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NewNoteActivity : AppCompatActivity() {

    private lateinit var editTextNote: EditText
    private lateinit var saveBtt: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_note)
        initComponent()
        initListeners()
    }

    private fun initListeners() {
        saveBtt.setOnClickListener {
            val note = editTextNote.text.toString()
            if (note.isNotEmpty()) {
                val intent = Intent(this, MyNotesActivity::class.java)
                intent.putExtra("EXTRA_NAME_NOTE", note)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun initComponent() {
        saveBtt = findViewById(R.id.save_btt)
        editTextNote = findViewById(R.id.etNote)
    }
}