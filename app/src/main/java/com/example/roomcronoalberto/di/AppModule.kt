package com.example.roomcronoalberto.di

import android.content.Context
import androidx.room.Room
import com.example.roomcronoalberto.room.CronosDataBase
import com.example.roomcronoalberto.room.CronosDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesCronosDao(cronosDatabase: CronosDataBase): CronosDatabaseDao {
        return cronosDatabase.cronosDao()
    }
    @Singleton
    @Provides
    fun providesCronosDatabase(@ApplicationContext context: Context): CronosDataBase{
        return Room.databaseBuilder(
            context,
            CronosDataBase:: class.java, "cronos_db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}