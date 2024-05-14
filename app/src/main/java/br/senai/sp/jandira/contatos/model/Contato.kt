package br.senai.sp.jandira.contatos.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_contatos")
data class Contato(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String = "",
    val email: String = "",
    val telefone: String = "",
    @ColumnInfo(name = "data_nascimento") val dataNascimento: String = "",
    @ColumnInfo(name = "is_amigo") val isAmigo: Boolean = false
)
