package com.example.aula2023_09_21.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.aula2023_09_21.dados.EsquemaDB
import com.example.aula2023_09_21.dados.MeuBancoSQLite
import com.example.aula2023_09_21.modelo.Registro

class RegistroRepository(var context: Context) {

    lateinit var banco: MeuBancoSQLite
    lateinit var  conexao: SQLiteDatabase

    init {
        this.banco = MeuBancoSQLite(this.context)
        this.conexao = this.banco.writableDatabase
    }

    fun salvarRegistro(registro: Registro):Boolean{
        val valores:ContentValues = ContentValues()

        valores.put(EsquemaDB.tabela_registro.NOME_ATT, registro.nome)
        valores.put(EsquemaDB.tabela_registro.VALOR_ATT, registro.valor)
        if(registro.data_registro != null) {
            valores.put(EsquemaDB.tabela_registro.DATA_ATT, registro.data_registro!!.toEpochDay())
        }
        return this.conexao.insert(EsquemaDB.tabela_registro.NOME_TABELA,
            null, valores) > 0
    }

    fun somaEntradas(): Float {
        val query = "SELECT SUM(${EsquemaDB.tabela_registro.VALOR_ATT}) FROM ${EsquemaDB.tabela_registro.NOME_TABELA} WHERE ${EsquemaDB.tabela_registro.VALOR_ATT} > 0"
        val cursor = conexao.rawQuery(query, null)
        cursor.moveToFirst()
        val somaEntrada = cursor.getFloat(0)
        cursor.close()
        return somaEntrada
    }

    fun somaSaidas(): Float {
        val query = "SELECT SUM(${EsquemaDB.tabela_registro.VALOR_ATT}) FROM ${EsquemaDB.tabela_registro.NOME_TABELA} WHERE ${EsquemaDB.tabela_registro.VALOR_ATT} < 0"
        val cursor = conexao.rawQuery(query, null)
        cursor.moveToFirst()
        val somaSaida = cursor.getFloat(0)
        cursor.close()
        return somaSaida
    }

    fun saldo(): Float {
        val entradas = somaEntradas()
        val saidas = somaSaidas()
        return entradas - saidas
    }

}