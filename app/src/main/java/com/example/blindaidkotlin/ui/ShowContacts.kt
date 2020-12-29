package com.example.blindaidkotlin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.blindaidkotlin.R
import com.example.blindaidkotlin.adapter.ContactDetailsAdapter
import com.example.blindaidkotlin.databinding.FragmentShowContactsBinding
import com.example.blindaidkotlin.viewmodels.ContactDetailsViewModel

class ShowContacts : Fragment(R.layout.fragment_show_contacts) {
    lateinit var contactDetailsViewModel: ContactDetailsViewModel
    lateinit var binding: FragmentShowContactsBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShowContactsBinding.bind(view)

        val recyclerContactList = binding.recylclerContactList
        recyclerContactList.layoutManager = LinearLayoutManager(activity)

        val contactDetailsAdapter = ContactDetailsAdapter()
        recyclerContactList.adapter = contactDetailsAdapter

        contactDetailsViewModel =
            ViewModelProvider(requireActivity()).get(ContactDetailsViewModel::class.java)

        contactDetailsViewModel.contactDetailsList.observe(
            viewLifecycleOwner,
            { contactDetailsList ->
                contactDetailsAdapter.setData(contactDetailsList)
            })

        val addContactsToolBar = binding.toolbarShowContacts
        (activity as AppCompatActivity).setSupportActionBar(addContactsToolBar)
        (activity as AppCompatActivity).supportActionBar!!.title = "Contacts"

        val fab = binding.fabAddContacts

        fab.setOnClickListener {view:View ->
            view.findNavController().navigate(R.id.action_showContacts_to_addContacts)
        }
    }

}