package com.example.blindaidkotlin.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.blindaidkotlin.Repository.ContactDetailsRepository
import com.example.blindaidkotlin.data.ContactDetailsDatabase
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.logic.dao.ContactDetailsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val contactDetailsRepository:ContactDetailsRepository

    init {
        val dao:ContactDetailsDao = ContactDetailsDatabase.getDatabase(application).contactDetailsDao()
        contactDetailsRepository = ContactDetailsRepository(dao)
        contactDetailsRepository.read_phone_no
    }

    fun addUser(contactDetails: ContactDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            contactDetailsRepository.addUser(contactDetails)
        }

    }
}