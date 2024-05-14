package br.senai.sp.jandira.contatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.contatos.screens.FormularioContatos
import br.senai.sp.jandira.contatos.screens.TelaHome
import br.senai.sp.jandira.contatos.ui.theme.ContatosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContatosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val controladorDeNavegacao = rememberNavController()
                    NavHost(
                        navController = controladorDeNavegacao,
                        startDestination = "home"
                    ){
                        composable(route = "home") { TelaHome(controladorDeNavegacao) }
                        composable(route = "cadastro") { FormularioContatos(controladorDeNavegacao) }
                    }
                }
            }
        }
    }
}
