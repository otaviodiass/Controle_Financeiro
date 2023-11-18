package com.example.aula2023_09_21.dados

class EsquemaDB {

    companion object{
        val NOME_DB: String = "bd_if_vida"
        val VERSAO: Int = 1
    }

    object tabela_registro{
        val NOME_TABELA = "registro"
        val ID_ATT = "id"
        val NOME_ATT = "nome"
        val VALOR_ATT = "valor"
        val DATA_ATT = "data"
        val CRIA_TABELA = "CREATE TABLE IF NOT EXISTS $NOME_TABELA " +
                "($ID_ATT INTEGER primary key autoincrement, " +
                "$NOME_ATT text, $VALOR_ATT real, $DATA_ATT integer)"
    }

}