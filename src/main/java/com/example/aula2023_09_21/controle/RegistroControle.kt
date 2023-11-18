package com.example.aula2023_09_21.controle

import android.content.Context
import com.example.aula2023_09_21.modelo.Registro
import com.example.aula2023_09_21.repository.RegistroRepository

class RegistroControle (var context: Context){

    lateinit var repository: RegistroRepository

    init {
        repository = RegistroRepository(context)
    }

    fun salvarRegistro(nome: String, valor: String, data: String, sinal: Boolean) : Boolean {

        if (nome != null && valor != null && data != null) {
            val valorFloat = valor.toFloat()
            val valorFinal = if (sinal) -valorFloat else valorFloat
            val registro: Registro = Registro(nome, valorFinal, data)
            return repository.salvarRegistro(registro)
        }
        return false
    }
}
