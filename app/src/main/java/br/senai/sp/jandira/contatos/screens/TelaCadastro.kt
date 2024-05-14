package br.senai.sp.jandira.contatos.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.contatos.R
import br.senai.sp.jandira.contatos.model.Contato
import br.senai.sp.jandira.contatos.repository.ContatoRepository
import br.senai.sp.jandira.contatos.ui.theme.ContatosTheme

@Composable
fun FormularioContatos(controladorDeNavegacao: NavHostController) {

    var nomeState = remember {
        mutableStateOf("")
    }

    var emailState = remember {
        mutableStateOf("")
    }

    var foneState = remember {
        mutableStateOf("")
    }

    var dataNascimentoState = remember {
        mutableStateOf("")
    }

    var isAmigoState = remember {
        mutableStateOf(false)
    }

    val cr = ContatoRepository(LocalContext.current)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.title_new_contact),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Magenta
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = nomeState.value,
            onValueChange = {
                nomeState.value = it
            },
            label = {
                Text(text = stringResource(id = R.string.contact_name))
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = emailState.value,
            onValueChange = {
                emailState.value = it
            },
            label = {
                Text(text = stringResource(id = R.string.contact_email))
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = foneState.value,
            onValueChange = {
                foneState.value = it
            },
            label = {
                Text(text = stringResource(id = R.string.contact_number))
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = dataNascimentoState.value,
            onValueChange = {
                dataNascimentoState.value = it
            },
            label = {
                Text(text = stringResource(id = R.string.contact_data))
            },
            modifier = Modifier.fillMaxWidth()
        )
        Row {
            Checkbox(
                checked = isAmigoState.value,
                onCheckedChange = {
                    isAmigoState.value = it
                }
            )
            Text(
                text = stringResource(id = R.string.is_friend),
                modifier = Modifier.offset(y = 13.dp)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                val contato = Contato(
                    nome = nomeState.value,
                    email = emailState.value,
                    telefone = foneState.value,
                    isAmigo = isAmigoState.value
                )
                cr.salvar(contato)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.save))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ContatosTheme {
        //FormularioContatos(controladorDeNavegacao)
    }
}