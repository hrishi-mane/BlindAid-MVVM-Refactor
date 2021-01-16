package com.example.blindaidkotlin.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.blindaidkotlin.data.models.ContactDetails


@Dao
interface ContactDetailsDao {

    @Query("Select * from contact_details")
    fun readAllContacts(): LiveData<List<ContactDetails>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addContact(contactDetails: ContactDetails)

    @Delete
    suspend fun deleteContact(contactDetails: ContactDetails)

    @Query("Select phone from contact_details where phone = :phone_no")
    fun readPhoneNumber(phone_no: String): LiveData<String>

}