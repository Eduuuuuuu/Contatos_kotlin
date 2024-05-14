package br.senai.sp.jandira.contatos.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import br.senai.sp.jandira.contatos.repository.ContatoRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaHome(controladorDeNavegacao: NavHostController) {

    val cr = ContatoRepository(LocalContext.current)
    val contatos = cr.listarTodosOsContatos()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Meu Contatos",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF3F51B5))
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(
                    text = "Barra de rodapé"
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { controladorDeNavegacao }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                LazyColumn{
                    items(contatos){
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row {
                                Column {
                                    Text(text = it.nome)
                                    Text(text = it.email)
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}