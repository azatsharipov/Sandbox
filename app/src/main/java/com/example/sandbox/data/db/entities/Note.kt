package com.example.sandbox.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Notes")
data class Note (
    var title: String,
    var text: String
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}