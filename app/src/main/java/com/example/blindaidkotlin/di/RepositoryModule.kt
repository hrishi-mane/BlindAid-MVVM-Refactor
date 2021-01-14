package com.example.blindaidkotlin.di

import com.example.blindaidkotlin.dao.ContactDetailsDao
import com.example.blindaidkotlin.repository.ContactDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun providesContactDetailsRepository(contactDetailsDao: ContactDetailsDao):ContactDetailsRepository{
        return ContactDetailsRepository(contactDetailsDao)
    }
}