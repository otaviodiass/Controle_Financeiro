package com.example.aula2023_09_21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.aula2023_09_21.controle.RegistroControle
import com.example.aula2023_09_21.databinding.ActivityMainBinding
import kotlin.math.sin

class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var binding: ActivityMainBinding
    lateinit var registroControle: RegistroControle
    var sinal: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        registroControle = RegistroControle(baseContext)

        setContentView(binding.root)

        configuraInicio()

    }

    private fun configuraInicio(){
        binding.RbEntrada.setOnClickListener(this)
        binding.RbSaida.setOnClickListener(this)
        binding.BtSalvar.setOnClickListener(this)
        binding.BtResumo.setOnClickListener(this)
    }

    override fun onClick(botao: View?) {
        if (botao != null) {
            when(botao.id){
                binding.BtSalvar.id -> executarSalvar()
                binding.BtResumo.id -> executarResumo()
                binding.RbEntrada.id -> entrada()
                binding.RbSaida.id -> saida()
            }
        }
    }

//    fun executarSalvar(){
//        if(registroControle.salvarRegistro(binding.TxNome.toString(), binding.TxValor.toString().toFloat(), binding.TxData.toString(), sinal)){
//            Toast.makeText(this, "Registro salvo com sucesso", Toast.LENGTH_LONG).show()
//        } else{
//            Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
//        }
//    }

    private fun executarSalvar() {
        Log.d("MeuApp", "Clicou em Salvar")
        try {
            registroControle.salvarRegistro(
                binding.TxNome.toString(),
                binding.TxValor.toString(),
                binding.TxData.toString(),
                sinal
            )
            Log.d("MeuApp", "Registro salvo com sucesso")
            finish()
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("MeuApp", "Erro ao salvar: ${e.message}")
            Toast.makeText(baseContext, "Erro ao salvar: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun executarResumo(){
        val transicaoResumo: Intent = Intent(baseContext, ResumoActivity::class.java)
        startActivity(transicaoResumo)
    }

    private fun entrada(){
        sinal = false
    }

    private fun saida(){
        sinal = true
    }
}