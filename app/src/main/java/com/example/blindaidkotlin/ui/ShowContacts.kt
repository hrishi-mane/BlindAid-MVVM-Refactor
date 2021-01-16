package com.example.blindaidkotlin.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blindaidkotlin.R
import com.example.blindaidkotlin.adapter.ContactDetailsAdapter
import com.example.blindaidkotlin.databinding.FragmentShowContactsBinding
import com.example.blindaidkotlin.ui.callbacks.SwipeToDeleteCallBack
import com.example.blindaidkotlin.viewmodels.ShowContactsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowContacts : Fragment(R.layout.fragment_show_contacts) {

    private val showContactsViewModel: ShowContactsViewModel by viewModels()
    lateinit var binding: FragmentShowContactsBinding
    val contactDetailsAdapter = ContactDetailsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShowContactsBinding.bind(view)

        val recyclerContactList = binding.recylclerContactList
        recyclerContactList.layoutManager = LinearLayoutManager(activity)


        recyclerContactList.adapter = contactDetailsAdapter

        setUpConsumer()

        val addContactsToolBar = binding.toolbarShowContacts

        (activity as AppCompatActivity).setSupportActionBar(addContactsToolBar)
        (activity as AppCompatActivity).supportActionBar!!.title = "Contacts"

        val fab = binding.fabAddContacts

        fab.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_showContacts_to_addContacts)
        }

        val swipeHandler = object : SwipeToDeleteCallBack(context) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = recyclerContactList.adapter as ContactDetailsAdapter
                showContactsViewModel.deleteContact(adapter.getContactAtPosition(viewHolder.adapterPosition))
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recyclerContactList)

    }

    private fun setUpConsumer() {
        showContactsViewModel.getContacts().observe(
            viewLifecycleOwner,
            { contactDetailsList ->
                contactDetailsAdapter.setContact(contactDetailsList)
            })
    }

}