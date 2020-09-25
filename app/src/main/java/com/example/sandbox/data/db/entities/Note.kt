package com.example.sandbox.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Note(
    var title: String,
    var text: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}