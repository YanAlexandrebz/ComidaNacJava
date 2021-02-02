package br.com.fiap.nac2contato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.nac2contato.database.ContatosDatabase
import br.com.fiap.nac2contato.database.atualizarContato
import br.com.fiap.nac2contato.database.inserirContato
import br.com.fiap.nac2contato.database.listarContatos

class MainActivity : AppCompatActivity() {

    lateinit var editTextContato: EditText
    lateinit var buttonAdicionar: Button
    lateinit var recyclerView: RecyclerView
    lateinit var database: ContatosDatabase

    val contatoAdapter = ContatoAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextContato = findViewById(R.id.editTextContato)
        buttonAdicionar = findViewById(R.id.buttonAdicionar)
        recyclerView = findViewById(R.id.recyclerView)

        database = ContatosDatabase(this)

        recyclerView.adapter = contatoAdapter
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //listar tarefas do banco
        database.listarContatos().forEach {
            contatoAdapter.addItem(it.copy(
                onUpdate = ::atualizarContato
            ))
        }

        buttonAdicionar.setOnClickListener {

            val contato = Contato(
                nome = editTextContato.text.toString(),

                onUpdate = ::atualizarTarefa
            )

            val idContato = database.inserirContato(contato)
            if(idContato != -1) {
                contatoAdapter.addItem(contato.copy(idContato = idContato))
            } else {
                Toast.makeText(this, "Erro ao inserir", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun atualizarContato(item: Contato) {
        database.atualizarContato(item)
    }
}
