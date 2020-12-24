package com.example.blindaidkotlin.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_details")
data class ContactDetails(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val phone: String
) {

}