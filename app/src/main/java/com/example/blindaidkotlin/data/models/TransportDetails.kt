package com.example.blindaidkotlin.data.models

import java.util.*

data class TransportDetails(
    val source: String,
    val destination: String,
    val number: Int,
    val dept_time: Date,
    val arrival_time: Date,
    val travel_time: Date
)
