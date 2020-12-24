package com.example.blindaidkotlin.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.blindaidkotlin.R
import com.example.blindaidkotlin.data.models.ContactDetails
import com.example.blindaidkotlin.viewmodels.ContactDetailsViewModel

class AddContacts : Fragment(R.layout.fragment_add_contacts) {

    private lateinit var mContactDetailsViewModel: ContactDetailsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContactDetailsViewModel = ViewModelProvider(this).get(ContactDetailsViewModel::class.java)

        val name:EditText = view.findViewById(R.id.editText_name)
        val phoneno:EditText = view.findViewById(R.id.editText_phoneno)


        view.findViewById<Button>(R.id.button_add).setOnClickListener {
                insertToDatabase(name.text.toString(), phoneno.text.toString())

        }



    }

    private fun insertToDatabase( name: String, phoneno: String) {
        val local_name:String = name
        val local_phoneno = phoneno

        mContactDetailsViewModel.addUser(ContactDetails(0, local_name, local_phoneno))
    }
}