package com.example.blindaidkotlin.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.blindaidkotlin.data.models.ContactDetails


@Dao
interface ContactDetailsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addContact(contactDetails: ContactDetails)

    @Query("Select * from contact_details")
    fun readAllContacts(): LiveData<List<ContactDetails>>

    @Delete
    fun deleteContact(contactDetails: ContactDetails)

}