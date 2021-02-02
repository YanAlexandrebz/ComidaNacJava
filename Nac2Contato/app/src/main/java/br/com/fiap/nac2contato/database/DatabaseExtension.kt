package br.com.fiap.nac2contato.database

import android.content.ContentValues
import br.com.fiap.nac2contato.Contato

fun ContatosDatabase.listarContatos(): List<Contato> {

    val sql = "SELECT * FROM TBL_CONTATOS"

    val cursor = this.readableDatabase.rawQuery(sql, null)

    val resultados = mutableListOf<Contato>()

    while (cursor.moveToNext()) {

        val id = cursor.getInt(cursor.getColumnIndex("ID"))
        val nome = cursor.getString(cursor.getColumnIndex("NOME"))
        val email = cursor.getString(cursor.getColumnIndex("EMAIL"))
        val telefone = cursor.getString(cursor.getColumnIndex("TELEFONE"))

        resultados.add(
            Contato(
                nome = nome,
                idContato = id,
                email = email,
                telefone = telefone
            )
        )
    }
    cursor.close()

    return resultados
}

fun ContatosDatabase.inserirContato(item: Contato): Int {

    val id = this.writableDatabase.insert("TBL_CONTATOS", null, ContentValues().apply {
        put("NOME", item.nome)

    })

    return id.toInt()
}

fun ContatosDatabase.atualizarContato(item: Contato): Int {

    val valores = ContentValues().apply {
        //ação
    }

    return this.writableDatabase.update("TBL_CONTATOS", valores, "ID=${item.idContato}", null)
}

fun ContatosDatabase.removerContato(idContato:Int?): Int {
    return this.writableDatabase.delete("TBL_CONTATOS", "ID=${idContato}", null)
}