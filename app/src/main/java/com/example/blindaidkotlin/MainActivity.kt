package com.example.blindaidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blindaidkotlin.logic.dao.ContactDetailsDao

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}