package com.example.blindaidkotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.repository.LocalDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowContactsViewModel
@Inject
constructor(
    private val localDataRepository: LocalDataRepository
) : ViewModel() {

    fun getContacts(): LiveData<List<ContactDetails>> {
        return localDataRepository.getContacts()
    }

    fun deleteContact(contactDetails: ContactDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            localDataRepository.deleteContact(contactDetails)

        }
    }

}