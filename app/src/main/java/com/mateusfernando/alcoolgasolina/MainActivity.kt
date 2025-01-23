package com.mateusfernando.alcoolgasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textInputAlcool: TextInputLayout
    private lateinit var editalcool: TextInputEditText

    private lateinit var textInputGasolina: TextInputLayout
    private lateinit var editGasolina: TextInputEditText

    private lateinit var btnCalcular: Button
    private lateinit var textResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializarComponentesInterface()
        btnCalcular.setOnClickListener {
            calcularMelhorPreco()
        }
    }

    private fun calcularMelhorPreco() {

        val precoAlcool = editalcool.text.toString()
        val precoGasolina = editGasolina.text.toString()

        val resultadoValidacao = validarCampos( precoAlcool, precoGasolina)

        if (resultadoValidacao){

            val precoGasolinaNumero = precoGasolina.toDouble()
            val precoAlcoolNumero = precoAlcool.toDouble()
            val resultado = precoAlcoolNumero / precoGasolinaNumero

            if ( resultado >= 0.7) {
                textResultado.text = "Melhor Utilizar Gasolina"
            }else {
                textResultado.text = "Melhor utilizar Álcool"
            }
        }

    }

    private fun validarCampos(pAlcool: String, pGasolina: String): Boolean {

        textInputAlcool.error = null
        textInputGasolina.error = null

        if ( pAlcool.isEmpty() ){
            textInputAlcool.error = "Digite o preço do Alcool"
            return false
        } else if ( pGasolina.isEmpty() ){
            textInputGasolina.error = "Digite o preço da Gasolina"
            return false
        }

        return true


    }


    private fun inicializarComponentesInterface() {
        textInputAlcool = findViewById(R.id.text_input_alcool)
        editalcool = findViewById(R.id.edit_alcool)

        textInputGasolina = findViewById(R.id.text_input_gasolina)
        editGasolina = findViewById(R.id.edit_gasolina)

        btnCalcular = findViewById(R.id.btn_calcular)
        textResultado = findViewById(R.id.text_resultado)

    }
}