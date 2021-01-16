package com.example.blindaidkotlin.repository

import androidx.lifecycle.LiveData
import com.example.blindaidkotlin.dao.ContactDetailsDao
import com.example.blindaidkotlin.data.models.ContactDetails

class LocalDataRepository
constructor(
    private val contactDetailsDao: ContactDetailsDao
) {
    fun getContacts():LiveData<List<ContactDetails>>{
        return contactDetailsDao.readAllContacts()
    }
    suspend fun addContact(contactDetails: ContactDetails) {
        contactDetailsDao.addContact(contactDetails)
    }

    suspend fun deleteContact(contactDetails: ContactDetails) {
        contactDetailsDao.deleteContact(contactDetails)
    }

    fun getPhoneNumber(phone_no:String):LiveData<String>{
        return contactDetailsDao.readPhoneNumber(phone_no)
    }
}