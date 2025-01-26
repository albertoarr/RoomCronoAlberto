package com.example.roomcronoalberto.state

data class CronoState(
    val cronometroActivo: Boolean=false,
    val showSaveButton: Boolean=false,
    val showTextFile: Boolean=false,
    val title: String=""


)
