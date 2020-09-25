package com.example.sandbox.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sandbox.data.db.entities.Note

@Dao
interface NotesDao {
    @Query("SELECT * FROM Notes")
//    fun getAll(): List<Note>
    fun getAll(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun delete(note: Note)
}