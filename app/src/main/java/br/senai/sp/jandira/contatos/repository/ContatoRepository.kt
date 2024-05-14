package br.senai.sp.jandira.contatos.repository

import android.content.Context
import br.senai.sp.jandira.contatos.dao.ContatoDb
import br.senai.sp.jandira.contatos.model.Contato

class ContatoRepository(context: Context) {

    private val db = ContatoDb.getBancoDeDados(context).contatoDao()

    fun salvar(contato: Contato): Long {
        return db.salvar(contato)
    }

    fun listarTodosOsContatos(): List<Contato> {
        return db.listarTodosOsContatos()
    }

}