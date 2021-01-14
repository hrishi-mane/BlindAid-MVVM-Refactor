package com.example.blindaidkotlin.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.blindaidkotlin.dao.ContactDetailsDao
import com.example.blindaidkotlin.data.models.ContactDetails

@Database(entities = [ContactDetails::class], version = 1, exportSchema = false)
abstract class ContactDetailsDatabase : RoomDatabase() {
    abstract fun contactDetailsDao(): ContactDetailsDao

}