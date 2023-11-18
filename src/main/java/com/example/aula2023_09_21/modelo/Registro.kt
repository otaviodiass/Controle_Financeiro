package com.example.aula2023_09_21.modelo

import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Registro(var nome:String, var valor:Float) {
    private val formatadorData = DateTimeFormatter.ofPattern("dd/MM/uuuu")

    var data_registro: LocalDate? = null

    //usuário cadastra e arma.
    constructor(
        nome: String,
        valor: Float,
        data: String): this(nome, valor) {
        this.data_registro = LocalDate.parse(data, formatadorData)
    }

    //recupero esse usuário do meu banco
    constructor(
        nome: String,
        valor: Float,
        data: Long) : this(nome, valor) {
        this.data_registro = LocalDate.ofEpochDay(data)
    }
}