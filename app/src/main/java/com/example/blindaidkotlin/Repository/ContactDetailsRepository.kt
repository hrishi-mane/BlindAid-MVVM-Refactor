package com.example.blindaidkotlin.Repository

import androidx.lifecycle.LiveData
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.logic.dao.ContactDetailsDao

class ContactDetailsRepository(private val contactDetailsDao: ContactDetailsDao) {
    val read_phone_no:LiveData<String> = contactDetailsDao.readPhone()


    fun addUser(contactDetails: ContactDetails){

        contactDetailsDao.addUser(contactDetails)
    }
}