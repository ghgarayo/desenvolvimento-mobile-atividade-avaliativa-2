package com.example.atividadeavaliativa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.atividadeavaliativa.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private var dao = PessoaDB.getInstance(this).getPessoaDAO()
    private var id = 0;
    private lateinit var pessoa: Pessoa

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        id = intent.getIntExtra("id", 0);

        if( id > 0 ){
            binding.txtAcaoActivity.text = "Editar Pessoa"

            pessoa = dao.getPessoa(id);

            binding.editNome.setText(pessoa.nome)
            binding.editEmail.setText(pessoa.email)
            binding.editTelefone.setText(pessoa.telefone)
        }

        binding.btnSalvar.setOnClickListener {
            validarDados()
        }
    }

    private fun validarDados(){

        if( binding.editNome.text.isEmpty() ||
            binding.editEmail.text.isEmpty() ||
            binding.editTelefone.text.isEmpty() ){

            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT)
                .show()
            return
        } else {

            pessoa = Pessoa(
                id,
                binding.editNome.text.toString(),
                binding.editEmail.text.toString(),
                binding.editTelefone.text.toString()
            )

            if( id > 0 ){
                dao.atualizarPessoa(pessoa)
                Toast.makeText(this, "Pessoa atualizada com sucesso", Toast.LENGTH_SHORT)
                    .show()
            } else {
                dao.salvarPessoa(pessoa)
                Toast.makeText(this, "Pessoa cadastrada com sucesso", Toast.LENGTH_SHORT)
                    .show()
            }

            finish()
        }
    }

}