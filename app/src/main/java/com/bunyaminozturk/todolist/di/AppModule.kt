package com.bunyaminozturk.todolist.di

import android.content.Context
import androidx.room.Room
import com.bunyaminozturk.todolist.data.datasource.TodosDataSource
import com.bunyaminozturk.todolist.data.repo.TodosRepository
import com.bunyaminozturk.todolist.room.TodosDao
import com.bunyaminozturk.todolist.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTodosDataSource(tdao: TodosDao): TodosDataSource {
        return TodosDataSource(tdao)
    }

    @Provides
    @Singleton
    fun provideTodosRepository(tds: TodosDataSource): TodosRepository {
        return TodosRepository(tds)
    }

    @Provides
    @Singleton
    fun provideTodosDao(@ApplicationContext context: Context): TodosDao {
        val vt = Room.databaseBuilder(context, Veritabani::class.java, "todos.sqlite")
            .createFromAsset("todos.sqlite").build()
        return vt.getTodosDao()
    }

}