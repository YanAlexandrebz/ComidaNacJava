package br.com.fiap.nac2contato

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContatoAdapter: RecyclerView.Adapter<ContatoViewHolder>() {

    private val items = mutableListOf<Contato>()

    fun addItem(newItem: Contato) {
        items.add(newItem)

        //notificar que houve mudanças na lista
        notifyDataSetChanged()
    }

    private fun notifyDataSetChanged() {
        TODO("Not yet implemented")
    }


    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ContatoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

}