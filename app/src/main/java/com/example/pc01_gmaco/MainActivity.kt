package com.example.pc01_gmaco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var etExamenParcial: EditText
    private lateinit var etExamenFinal: EditText
    private lateinit var etPEP: EditText
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etExamenParcial = findViewById(R.id.et_examen_parcial)
        etExamenFinal = findViewById(R.id.et_examen_final)
        etPEP = findViewById(R.id.et_pep)
        btnCalcular = findViewById(R.id.btn_calcular)

        btnCalcular.setOnClickListener {
            val notaExamenParcial = etExamenParcial.text.toString().toDouble()
            val notaExamenFinal = etExamenFinal.text.toString().toDouble()
            val notaPEP = etPEP.text.toString().toDouble()

            val notaFinal = (notaExamenParcial * 0.2) + (notaExamenFinal * 0.2) + (notaPEP * 0.6)
            val aprobado = notaFinal >= 10.5

            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            intent.putExtra("notaFinal", notaFinal)
            intent.putExtra("aprobado", aprobado)
            startActivity(intent)
        }
    }
}
