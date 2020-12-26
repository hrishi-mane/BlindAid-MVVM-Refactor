package com.example.blindaidkotlin.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.blindaidkotlin.R
import com.example.blindaidkotlin.databinding.FragmentShowContactsBinding

class ShowContacts : Fragment(R.layout.fragment_show_contacts) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding: FragmentShowContactsBinding = FragmentShowContactsBinding.bind(view)

        binding.fabAddContacts.setOnClickListener { view
            view.findNavController().navigate(R.id.action_showContacts_to_addContacts)
        }

    }

}