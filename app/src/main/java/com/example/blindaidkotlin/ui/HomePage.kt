package com.example.blindaidkotlin.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.blindaidkotlin.R

class HomePage : Fragment(R.layout.fragment_home_page) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_add_contacts).setOnClickListener {view:View ->
            view.findNavController().navigate(R.id.action_homePage_to_addContacts)
        }

        view.findViewById<Button>(R.id.image_button_one).setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homePage_to_busInfo)
        }

        view.findViewById<Button>(R.id.image_button_two).setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_homePage_to_sendLocation)
        }
    }
}