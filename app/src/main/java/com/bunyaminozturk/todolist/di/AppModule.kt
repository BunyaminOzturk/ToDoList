package com.bunyaminozturk.todolist.di

import com.bunyaminozturk.todolist.data.datasource.TodosDataSource
import com.bunyaminozturk.todolist.data.repo.TodosRepository
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
    fun provideTodosDataSource(): TodosDataSource {
        return TodosDataSource()
    }

    @Provides
    @Singleton
    fun provideTodosRepository(tds: TodosDataSource): TodosRepository {
        return TodosRepository(tds)
    }

}