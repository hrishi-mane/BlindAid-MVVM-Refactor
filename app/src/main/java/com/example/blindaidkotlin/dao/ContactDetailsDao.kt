package com.example.blindaidkotlin.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.blindaidkotlin.data.models.ContactDetails

@Dao
interface ContactDetailsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(contactDetails: ContactDetails)

    @Query("Select * from contact_details")
    fun readAllData(): LiveData<List<ContactDetails>>

}