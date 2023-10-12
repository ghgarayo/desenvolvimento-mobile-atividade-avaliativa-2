package com.example.atividadeavaliativa

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PessoaAdapter(var context: Context): RecyclerView.Adapter<PessoaViewHolder>() {

    private var pessoaDAO = PessoaDB.getInstance(context).getPessoaDAO()
    private var listaPessoas = pessoaDAO.getPessoas();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
        val pessoaLayout = LayoutInflater.from(context).inflate(R.layout.pessoa_layout, parent, false)
        return PessoaViewHolder(pessoaLayout)
    }

    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        var pessoa = listaPessoas.get(position)
        holder.textDadosPessoa.text = pessoa.toString()

        holder.textDadosPessoa.setOnClickListener {
            var intent = Intent(context, CadastroActivity::class.java)
            intent.putExtra("id", pessoa.id)
            context.startActivity(intent)
        }

        holder.textDadosPessoa.setOnLongClickListener {
            pessoaDAO.deletarPessoa(pessoa)
            atualizarAdapter()
            Toast.makeText(context, "Pessoa removida com sucesso", Toast.LENGTH_SHORT)
                .show()
            true
        }
    }

    override fun getItemCount(): Int {
        return listaPessoas.size
    }

    fun atualizarAdapter() {
        listaPessoas = emptyList()
        listaPessoas = pessoaDAO.getPessoas()
        notifyDataSetChanged()
    }

}