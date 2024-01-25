package com.osmancandincer.todoapp.di

import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import com.osmancandincer.todoapp.data.datasource.TaskDataSource
import com.osmancandincer.todoapp.data.repo.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton

    fun provideTaskDataSource(collectionTasks: CollectionReference) : TaskDataSource{
        return TaskDataSource(collectionTasks)
    }

    @Provides
    @Singleton

    fun provideTaskRepository(tds: TaskDataSource) : TaskRepository{
        return TaskRepository(tds)
    }

    @Provides
    @Singleton

    fun provideTasksCollectionReferance() : CollectionReference{
        return Firebase.firestore.collection("Tasks")
    }
}