package com.example.roomcronoalberto.state

import androidx.room.Entity

@Entity
data class CronoState(
    val cronometroActivo: Boolean=false,
    val showSaveButton: Boolean=false,
    val showTextFile: Boolean=false,
    val title: String=""


)
