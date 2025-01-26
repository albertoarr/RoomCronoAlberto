package com.example.roomcronoalberto.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.roomcronoalberto.model.Cronos
import kotlinx.coroutines.flow.Flow

@Dao
interface CronosDatabaseDao {
    //Crud
    @Query("SELECT * FROM cronos")
    fun getCronos(): Flow<List<Cronos>>

    @Query("SELECT * FROM cronos WHERE id=:id")
    fun getCronosById(id:Long): Flow<Cronos>

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    suspend fun insert(cronos:Cronos)

    @Update(onConflict= OnConflictStrategy.REPLACE)
    suspend fun update(cronos:Cronos)

    @Delete
    suspend fun delete (crono:Cronos)
}