package br.com.fiap.nac2contato

data class Contato (
    val idContato:Int? = null,
    var nome: String,
    var email: String,
    var telefone: String,

    val onUpdate: ((Contato)->Unit)? = null
)