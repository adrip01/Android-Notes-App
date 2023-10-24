package com.example.menotes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var tvNote: TextView = view.findViewById(R.id.tvNote)

    fun render(note: Note) {
        tvNote.text = note.content
    }
}