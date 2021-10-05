package com.example.blindaidkotlin.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.repository.LocalDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddContactsViewModel
@Inject
constructor(
    private val localDataRepository: LocalDataRepository
) : ViewModel() {

    fun addContact(contactDetails: ContactDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            localDataRepository.addContact(contactDetails)
        }
    }
}