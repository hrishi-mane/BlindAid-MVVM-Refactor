package com.example.blindaidkotlin.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.blindaidkotlin.R
import com.example.blindaidkotlin.databinding.FragmentSendLocationBinding
import com.example.blindaidkotlin.viewmodels.SendLocationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SendLocation : Fragment(R.layout.fragment_send_location) {
    private val sendLocationViewModel: SendLocationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentSendLocationBinding = FragmentSendLocationBinding.bind(view)
        val sendLocationButton = fragmentSendLocationBinding.sendLocationButton

        sendLocationButton.setOnClickListener {
            sendLocationViewModel.startListening()
        }


        setUpResultObserver()
    }

    private fun setUpResultObserver() {
        sendLocationViewModel.sendStatus.observe(viewLifecycleOwner, { sendStatus ->
            when(sendStatus){
                2 -> Toast.makeText(context, "Message Sent Successfully", Toast.LENGTH_SHORT).show()
                1 -> Toast.makeText(context, "Message Failed. The contact does not exist", Toast.LENGTH_SHORT).show()
                0 -> Toast.makeText(context, "Message Failed. Please check if necessary permissions are granted.", Toast.LENGTH_SHORT).show()
            }

        })
    }
    
}