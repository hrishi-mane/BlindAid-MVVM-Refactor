package com.example.blindaidkotlin.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.repository.ContactDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactDetailsViewModel

@ViewModelInject
constructor(
    private val contactDetailsRepository: ContactDetailsRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val contactDetailsList: LiveData<List<ContactDetails>> =
        contactDetailsRepository.contactDetailsList

    fun addUser(contactDetails: ContactDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            contactDetailsRepository.addUser(contactDetails)
        }
    }

    fun deleteContact(contactDetails: ContactDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            contactDetailsRepository.deleteContact(contactDetails)

        }
    }
}