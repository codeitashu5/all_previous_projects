package com.sumit.userapp.di

import android.app.Application
import androidx.room.Room
import com.sumit.userapp.database.AppDatabase
import com.sumit.userapp.database.dao.UserDao
import com.sumit.userapp.networking.NetWorkProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideDatabase(application: Application): AppDatabase =
        Room.databaseBuilder(application, AppDatabase::class.java, "my_db")
            .build()

    @Provides
    @Singleton
    fun provideUserDao(appDatabase: AppDatabase) : UserDao = appDatabase.userDao()

    @Provides
    @Singleton
    fun provideNetworkProvider() = NetWorkProvider()
}