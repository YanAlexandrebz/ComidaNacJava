package br.com.fiap.nac2contato

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContatoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val textViewContato = view.findViewById<TextView>(R.id.textViewContato)

    fun bind(item: Contato) {

        textViewContato.text = item.nome
        textViewContato.text = item.email
        textViewContato.text = item.telefone
    }
    
    
}