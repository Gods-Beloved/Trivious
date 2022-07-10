package com.example.googleauthapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.example.trivious.data.repository.DataStoreOperationImpl
import com.example.trivious.data.repository.RepositoryImpl
import com.example.trivious.domain.repository.DataStoreOperations
import com.example.trivious.domain.repository.Repository
import com.example.trivious.server.ServerApi
import com.example.trivious.util.Constant.PREFERENCES_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStorePreference(
        @ApplicationContext
        context: Context
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = {
                context.preferencesDataStoreFile(PREFERENCES_NAME)
            }
        )
    }

    @Provides
    @Singleton
    fun providesDataStoreOperations(
        dataStore: DataStore<Preferences>
    ): DataStoreOperations {
        return DataStoreOperationImpl(dataStore = dataStore)
    }


    @Provides
    @Singleton
    fun providesRepository(
        dataStoreOperations: DataStoreOperations,
        serverApi: ServerApi
    ): Repository {
        return RepositoryImpl(dataStoreOperations = dataStoreOperations, serverApi =  serverApi )

    }
}