package com.example.atividadeavaliativa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.atividadeavaliativa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pessoaAdapter: PessoaAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pessoaAdapter = PessoaAdapter(this)

        binding.rcvPessoas.layoutManager = LinearLayoutManager(this)
        binding.rcvPessoas.adapter = pessoaAdapter

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java ))
        }
    }

    override fun onStart() {
        super.onStart()
        pessoaAdapter.atualizarAdapter()
    }

}