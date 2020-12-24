package com.example.blindaidkotlin.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.logic.dao.ContactDetailsDao

@Database(entities = [ContactDetails::class], version = 1, exportSchema = false)
abstract class ContactDetailsDatabase: RoomDatabase() {
    abstract fun contactDetailsDao():ContactDetailsDao

    companion object{
        private var INSTANCE: ContactDetailsDatabase? = null

        fun getDatabase(context: Context):ContactDetailsDatabase{
            val temp_instance = INSTANCE
            if(temp_instance != null){
                return temp_instance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDetailsDatabase::class.java,
                    "contact_details_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}