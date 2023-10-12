package com.example.atividadeavaliativa

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pessoa::class], version = 1)
abstract class PessoaDB : RoomDatabase() {

    abstract fun getPessoaDAO(): PessoaDAO
    companion object {

        private lateinit var INSTANCE: PessoaDB

        fun getInstance(context: Context): PessoaDB {

            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context, PessoaDB::class.java, "pessoas_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}