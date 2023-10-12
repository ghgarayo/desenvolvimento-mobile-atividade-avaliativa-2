package com.example.atividadeavaliativa

import androidx.room.*
@Dao
interface PessoaDAO {
    @Insert
    fun salvarPessoa(pessoa: Pessoa) : Long

    @Delete
    fun deletarPessoa(pessoa: Pessoa)

    @Update
    fun atualizarPessoa(pessoa: Pessoa)

    @Query("SELECT * FROM pessoas WHERE id = :id")
    fun getPessoa(id: Int) : Pessoa

    @Query("SELECT * FROM pessoas")
    fun getPessoas() : List<Pessoa>
}


