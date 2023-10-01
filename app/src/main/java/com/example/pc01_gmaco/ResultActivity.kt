package com.example.pc01_gmaco

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // Obtén la nota final del intent
        val examenParcial = intent.getDoubleExtra("examen_parcial", 0.0)
        val examenFinal = intent.getDoubleExtra("examen_final", 0.0)
        val pep = intent.getDoubleExtra("pep", 0.0)
        val notaFinal = (examenParcial * 0.20) + (examenFinal * 0.20) + (pep * 0.60)

        // Calcula si el estudiante aprobó o no
        val aprobado = notaFinal >= 10.5

        // Muestra la nota final y si el estudiante aprobó o no en los TextView correspondientes
        tvNotaFinal.text = notaFinal.toString()
        tvAprobado.text = if (aprobado) "Aprobado" else "Reprobado"
    }
}

