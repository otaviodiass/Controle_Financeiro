package com.example.aula2023_09_21

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aula2023_09_21.databinding.ActivityMainBinding
import com.example.aula2023_09_21.databinding.ActivityMainResumoBinding
import com.example.aula2023_09_21.repository.RegistroRepository

class ResumoActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainResumoBinding
    lateinit var registroRepository: RegistroRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainResumoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        entradaResumo()
        saidaResumo()
        totalResumo()
    }

    private fun entradaResumo(){
        val resp = registroRepository.somaEntradas()
        binding.TxCaixa.text = resp.toString()
    }

    fun saidaResumo(){
        val resp = registroRepository.somaSaidas()
        binding.TxCaixa.text = resp.toString()
    }

    fun totalResumo(){
        val resp = registroRepository.saldo()
        binding.TxCaixa.text = resp.toString()
    }

}