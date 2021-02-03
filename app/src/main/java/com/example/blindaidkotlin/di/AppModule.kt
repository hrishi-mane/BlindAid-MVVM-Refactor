package com.example.blindaidkotlin.di

import android.content.Context
import androidx.room.Room
import com.example.blindaidkotlin.dao.ContactDetailsDao
import com.example.blindaidkotlin.data.ContactDetailsDatabase
import com.example.blindaidkotlin.repository.LocalDataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context:Context): ContactDetailsDatabase {

        return Room.databaseBuilder(
            context.applicationContext,
            ContactDetailsDatabase::class.java,
            "contact_details_database"
        ).build()

    }

    @Singleton
    @Provides
    fun provideDao(contactDetailsDatabase: ContactDetailsDatabase):ContactDetailsDao{
        return contactDetailsDatabase.contactDetailsDao()
    }



    @Singleton
    @Provides
    fun providesContactDetailsRepository(contactDetailsDao: ContactDetailsDao): LocalDataRepository {
        return LocalDataRepository(contactDetailsDao)
    }
}