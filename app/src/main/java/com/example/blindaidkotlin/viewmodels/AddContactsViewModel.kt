package com.example.blindaidkotlin.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.repository.LocalDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddContactsViewModel

@ViewModelInject
constructor(
    private val localDataRepository: LocalDataRepository
) : ViewModel() {

    fun addContact(contactDetails: ContactDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            localDataRepository.addContact(contactDetails)
        }
    }


}