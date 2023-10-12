package com.example.atividadeavaliativa

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pessoas")
data class Pessoa(
    @PrimaryKey(autoGenerate = true) @ColumnInfo var id : Int,
    @ColumnInfo var nome : String,
    @ColumnInfo var email: String,
    @ColumnInfo var telefone: String,
) {

    override fun toString(): String {
        return "Nome: $nome \nEmail: $email \nTelefone: $telefone"
    }

}