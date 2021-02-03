package com.example.blindaidkotlin.viewmodels

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.telephony.SmsManager
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blindaidkotlin.repository.LocalDataRepository
import com.example.blindaidkotlin.ui.callbacks.RecognitionListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class SendLocationViewModel
@ViewModelInject
constructor(
    private val speechRecognizer: SpeechRecognizer,
    private val recognizerIntent: Intent,
    private val localDataRepository: LocalDataRepository,
    private val smsManager: SmsManager
) : ViewModel() {

    val sendStatus: MutableLiveData<Int> = MutableLiveData()

    fun sendMessage(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val phoneNo : String ?  = localDataRepository.getPhoneNumber(name)
                if (phoneNo != null){
                    smsManager.sendTextMessage("+91$phoneNo", null, "Hello", null, null)
                    sendStatus.postValue(2)
                }
                else{
                    sendStatus.postValue(1)
                }

            } catch (e: Exception) {
                sendStatus.postValue(0)
                Log.d("Exception", "sendMessage: " + e.message)
            }
        }
    }


    fun startListening(){
        recognizerIntent.putExtra(
            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
        )
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())

        val recognitionListener: RecognitionListener = object : RecognitionListener() {
            override fun onResults(results: Bundle?) {
                val matches = results!!.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                if (matches != null) {
                    sendMessage(matches.get(0))
                }

            }
        }
        speechRecognizer.setRecognitionListener(recognitionListener)
        speechRecognizer.startListening(recognizerIntent)
    }


}

