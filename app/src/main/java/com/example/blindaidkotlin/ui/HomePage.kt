package com.example.blindaidkotlin.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.blindaidkotlin.R
import com.example.blindaidkotlin.databinding.FragmentHomePageBinding

class HomePage : Fragment(R.layout.fragment_home_page) {
    lateinit var fragmentHomePageBinding:FragmentHomePageBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentHomePageBinding = FragmentHomePageBinding.bind(view)

        fragmentHomePageBinding.buttonAddContacts.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homePage_to_addContacts)
        }

        fragmentHomePageBinding.imageButtonOne.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homePage_to_busInfo)
        }

        fragmentHomePageBinding.imageButtonTwo.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homePage_to_sendLocation)
        }
    }
}