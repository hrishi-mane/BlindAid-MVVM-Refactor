package com.example.blindaidkotlin.viewmodels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.repository.LocalDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShowContactsViewModel
@ViewModelInject
constructor(
    private val localDataRepository: LocalDataRepository
) : ViewModel() {

    init {
        Log.d("INIT", ": ")
    }

    fun getContacts(): LiveData<List<ContactDetails>> {
        return localDataRepository.getContacts()
    }

    fun deleteContact(contactDetails: ContactDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            localDataRepository.deleteContact(contactDetails)

        }
    }

}