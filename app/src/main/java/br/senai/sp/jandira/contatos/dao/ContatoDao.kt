package br.senai.sp.jandira.contatos.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.senai.sp.jandira.contatos.model.Contato

@Dao
interface ContatoDao {

    @Insert
    fun salvar(contato: Contato): Long

    @Update
    fun atualizar(contato: Contato): Int

    @Delete
    fun excluir(contato: Contato)

    @Query("SELECT * FROM tbl_contatos ORDER BY nome ASC")
    fun listarTodosOsContatos(): List<Contato>

    @Query("SELECT * FROM tbl_contatos WHERE nome = :nome ORDER BY nome ASC")
    fun buscarContatoPeloNome(nome: String): List<Contato>

    @Query("SELECT * FROM tbl_contatos WHERE id = :id")
    fun buscarContatoPeloId(id: Long): Contato

}