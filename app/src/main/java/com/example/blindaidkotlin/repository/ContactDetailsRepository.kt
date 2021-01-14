package com.example.blindaidkotlin.repository

import androidx.lifecycle.LiveData
import com.example.blindaidkotlin.dao.ContactDetailsDao
import com.example.blindaidkotlin.data.models.ContactDetails

class ContactDetailsRepository


constructor(
    private val contactDetailsDao: ContactDetailsDao
) {
    val contactDetailsList: LiveData<List<ContactDetails>> = contactDetailsDao.readAllContacts()

    fun addUser(contactDetails: ContactDetails) {
        contactDetailsDao.addContact(contactDetails)
    }

    fun deleteContact(contactDetails: ContactDetails) {
        contactDetailsDao.deleteContact(contactDetails)
    }
}