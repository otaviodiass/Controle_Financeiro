package com.example.aula2023_09_21.dados

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MeuBancoSQLite(var context: Context): SQLiteOpenHelper(context,
    EsquemaDB.NOME_DB, null, EsquemaDB.VERSAO) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(EsquemaDB.tabela_registro.CRIA_TABELA)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}