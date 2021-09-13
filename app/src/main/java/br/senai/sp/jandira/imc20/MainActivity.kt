package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // var = variavel || val = constante


        // criando as instancias das views
        // para que possam ser manipuladas no kotlin
        val editTxtPeso = findViewById<EditText>(R.id.edit_peso)
        val editTxtAltura = findViewById<EditText>(R.id.edit_altura)
        val button = findViewById<Button>(R.id.button_calcular)
        val resultadoImc = findViewById<TextView>(R.id.text_view_resultado)

        //adicionar um oouvinte de click no botao
        button.setOnClickListener {

            if (editTxtPeso.text.isEmpty()){
                editTxtPeso.error = "Peso é obrigatório!"
            }
            else if(editTxtAltura.text.isEmpty()){
                editTxtAltura.error = "Altura é obrigatório!"
            }
            else{
                val peso = editTxtPeso.text.toString().toInt()
                val altura = editTxtAltura.text.toString().toDouble()
                val imc = peso / (altura * altura)
                resultadoImc.text = String.format("%.2f", imc)
            }
        }
    }
}
