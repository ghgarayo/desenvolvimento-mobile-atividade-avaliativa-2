package com.example.atividadeavaliativa

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PessoaViewHolder(pessoaLayout: View) : RecyclerView.ViewHolder(pessoaLayout) {
    var textDadosPessoa = pessoaLayout.findViewById<TextView>(R.id.textDadosPessoa)

}
