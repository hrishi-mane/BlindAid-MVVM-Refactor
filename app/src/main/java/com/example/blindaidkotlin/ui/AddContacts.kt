package com.example.blindaidkotlin.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.blindaidkotlin.R
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.databinding.FragmentAddContactsBinding
import com.example.blindaidkotlin.viewmodels.ContactDetailsViewModel


class AddContacts : Fragment(R.layout.fragment_add_contacts) {

    lateinit var mcontactDetailsViewModel: ContactDetailsViewModel
    lateinit var name:EditText
    lateinit var phone:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addContactsBinding = FragmentAddContactsBinding.bind(view)

        val toolbar = addContactsBinding.toolbarAddContacts
        name = addContactsBinding.editTextName
        phone =  addContactsBinding.editTextNumber

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar!!.title = "Add Contact"

        mcontactDetailsViewModel = ViewModelProvider(this).get(ContactDetailsViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar_add_contacts, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_save_icon){
            insertToDatabase()
            view?.findNavController()?.navigate(R.id.action_addContacts_to_showContacts)
        }
        return true
    }

    private fun insertToDatabase() {
        val name:String = name.text.toString()
        val phone:String = phone.text.toString()
        mcontactDetailsViewModel.addUser(ContactDetails(0,name,phone))
    }
}