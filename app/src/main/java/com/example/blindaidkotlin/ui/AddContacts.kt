package com.example.blindaidkotlin.ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.blindaidkotlin.R
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.databinding.FragmentAddContactsBinding
import com.example.blindaidkotlin.viewmodels.ContactDetailsViewModel
import com.google.android.material.snackbar.Snackbar


class AddContacts : Fragment(R.layout.fragment_add_contacts) {

    lateinit var contactDetailsViewModel: ContactDetailsViewModel
    lateinit var name: EditText
    lateinit var phone: EditText
    val TAG: String = "LifeCycleMethods"

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: ")
        setHasOptionsMenu(true)

        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "onActivityCreated: ")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated: ")
        super.onViewCreated(view, savedInstanceState)

        val addContactsBinding = FragmentAddContactsBinding.bind(view)

        val toolbar = addContactsBinding.toolbarAddContacts
        name = addContactsBinding.editTextName
        phone = addContactsBinding.editTextNumber

        contactDetailsViewModel =
            ViewModelProvider(requireActivity()).get(ContactDetailsViewModel::class.java)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar!!.title = "Add Contact"
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_toolbar_add_contacts, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_save_icon) {
            insertToDatabase()

            val imm:InputMethodManager = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)

            activity?.onBackPressed()
            view?.let { Snackbar.make(it, "Contact Added", Snackbar.LENGTH_SHORT).show() }

        }
        return true
    }

    private fun insertToDatabase() {
        val name: String = name.text.toString()
        val phone: String = phone.text.toString()
        contactDetailsViewModel.addUser(ContactDetails(0, name, phone))
    }
}