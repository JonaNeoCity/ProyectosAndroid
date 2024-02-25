package com.example.evc02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.evc02.databinding.ActivityMostrarRespuestasBinding

class MostrarRespuestasActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMostrarRespuestasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarRespuestasBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Obtener los datos enviados desde la actividad anterior
        val respuestasPregunta1 = intent.getBooleanArrayExtra("respuestasPregunta1")
        val opcionSeleccionadaPregunta2 = intent.getStringExtra("opcionSeleccionadaPregunta2")
        val opcionSeleccionadaPregunta3 = intent.getStringExtra("opcionSeleccionadaPregunta3")
        val opcionSeleccionadaPregunta4 = intent.getStringExtra("opcionSeleccionadaPregunta4")
        val respuestasPregunta5 = intent.getBooleanArrayExtra("respuestasPregunta5")

        // Mostrar los datos en la interfaz de usuario
        mostrarRespuestas(respuestasPregunta1, opcionSeleccionadaPregunta2, opcionSeleccionadaPregunta3,
            opcionSeleccionadaPregunta4, respuestasPregunta5)
    }

    private fun mostrarRespuestas(respuestasPregunta1: BooleanArray?, opcionSeleccionadaPregunta2: String?,
                                  opcionSeleccionadaPregunta3: String?, opcionSeleccionadaPregunta4: String?,
                                  respuestasPregunta5: BooleanArray?) {
        val textoRespuestas = StringBuilder()

        // Mostrar respuestas de la pregunta 1
        if (respuestasPregunta1 != null) {
            textoRespuestas.append("Respuestas Pregunta 1:\n")
            for ((index, respuesta) in respuestasPregunta1.withIndex()) {
                textoRespuestas.append("Respuesta ${index + 1}: ${if (respuesta) "Sí" else "No"}\n")
            }
            textoRespuestas.append("\n")
        }

        // Mostrar respuesta de la pregunta 2
        if (!opcionSeleccionadaPregunta2.isNullOrEmpty()) {
            textoRespuestas.append("Respuesta pregunta 2: $opcionSeleccionadaPregunta2\n\n")
        }

        // Mostrar respuesta de la pregunta 3
        if (!opcionSeleccionadaPregunta3.isNullOrEmpty()) {
            textoRespuestas.append("Respuesta pregunta 3: $opcionSeleccionadaPregunta3\n\n")
        }

        // Mostrar respuesta de la pregunta 4
        if (!opcionSeleccionadaPregunta4.isNullOrEmpty()) {
            textoRespuestas.append("Respuesta pregunta 4: $opcionSeleccionadaPregunta4\n\n")
        }

        // Mostrar respuestas de la pregunta 5
        if (respuestasPregunta5 != null) {
            textoRespuestas.append("Respuestas Pregunta 5:\n")
            for ((index, respuesta) in respuestasPregunta5.withIndex()) {
                textoRespuestas.append("Respuesta ${index + 1}: ${if (respuesta) "Sí" else "No"}\n")
            }
        }

        // Establecer el texto en el TextView
        binding.tvrespuestas.text = textoRespuestas.toString()
    }

}


