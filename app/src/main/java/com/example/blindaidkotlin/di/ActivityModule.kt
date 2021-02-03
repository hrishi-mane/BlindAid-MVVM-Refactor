package com.example.blindaidkotlin.di

import android.content.Context
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.telephony.SmsManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@InstallIn(ActivityComponent::class)
@Module
object ActivityModule {

    @Provides
    fun provideSmsManager(): SmsManager {
        return SmsManager.getDefault()
    }

    @Provides
    fun provideSpeechRecognizer(@ApplicationContext context: Context): SpeechRecognizer {
        return SpeechRecognizer.createSpeechRecognizer(context)
    }

    @Provides
    fun provideRecognizerIntent(): Intent {
        return Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
    }

}