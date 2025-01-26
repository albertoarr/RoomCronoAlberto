package com.example.roomcronoalberto.room

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.example.roomcronoalberto.model.Cronos

@Database(entities = [Cronos::class], version=1, exportSchema=false)
abstract class CronosDataBase: RoomDatabase() {
    abstract fun cronosDao(): CronosDatabaseDao

}