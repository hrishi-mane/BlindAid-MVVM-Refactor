package com.example.blindaidkotlin.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.blindaidkotlin.repository.ContactDetailsRepository
import com.example.blindaidkotlin.data.ContactDetailsDatabase
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.dao.ContactDetailsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val contactDetailsRepository: ContactDetailsRepository //contactDetailsRepo
    val contactDetailsList: LiveData<List<ContactDetails>>//no data

    init {
        val dao: ContactDetailsDao =
            ContactDetailsDatabase.getDatabase(application).contactDetailsDao()
        contactDetailsRepository = ContactDetailsRepository(dao)
        contactDetailsList = contactDetailsRepository.contactDetailsList
    }

    fun addUser(contactDetails: ContactDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            contactDetailsRepository.addUser(contactDetails)
            // [User{5,a,9208123123}]
        }
    }


}