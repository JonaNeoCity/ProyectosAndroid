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
            val textoSintomas = StringBuilder()
            textoSintomas.append("Sintomas:\n")
            if (respuestasPregunta1.size >= 6) {
                textoSintomas.append("¿Presentas disminucion del gusto o del olfato?: ${if (respuestasPregunta1[0]) "Sí" else "No"}\n")
                textoSintomas.append("¿Presentas tos?: ${if (respuestasPregunta1[1]) "Sí" else "No"}\n")
                textoSintomas.append("¿Presentas dolor de garganta?: ${if (respuestasPregunta1[2]) "Sí" else "No"}\n")
                textoSintomas.append("¿Presentas congestion nasal?: ${if (respuestasPregunta1[3]) "Sí" else "No"}\n")
                textoSintomas.append("¿Presentas fiebre?: ${if (respuestasPregunta1[4]) "Sí" else "No"}\n")
                textoSintomas.append("¿No presentas ningun sintoma?: ${if (respuestasPregunta1[5]) "Sí" else "No"}\n")
                textoSintomas.append("\n")
            }
            textoRespuestas.append(textoSintomas)
        }



        // Mostrar respuesta de la pregunta 2
        if (!opcionSeleccionadaPregunta2.isNullOrEmpty()) {
            textoRespuestas.append("¿Tienes fiebre mayor a 37 grados?: $opcionSeleccionadaPregunta2\n\n")
        }

        // Mostrar respuesta de la pregunta 3
        if (!opcionSeleccionadaPregunta3.isNullOrEmpty()) {
            textoRespuestas.append("¿Vives solo en casa?: $opcionSeleccionadaPregunta3\n\n")
        }

        // Mostrar respuesta de la pregunta 4
        if (!opcionSeleccionadaPregunta4.isNullOrEmpty()) {
            textoRespuestas.append("¿Vives con un adulto mayor en casa?: $opcionSeleccionadaPregunta4\n\n")
        }

        // Mostrar respuestas de la pregunta 5
        if (respuestasPregunta5 != null) {
            val textoServicios = StringBuilder()
            textoServicios.append("Servicios:\n")
            if (respuestasPregunta5.size >= 4) {
                textoServicios.append("¿Cuentas con luz?: ${if (respuestasPregunta5[0]) "Sí" else "No"}\n")
                textoServicios.append("¿Cuentas con agua?: ${if (respuestasPregunta5[1]) "Sí" else "No"}\n")
                textoServicios.append("¿Cuentas con internet?: ${if (respuestasPregunta5[2]) "Sí" else "No"}\n")
                textoServicios.append("¿Cuentas con cable?: ${if (respuestasPregunta5[3]) "Sí" else "No"}\n")
                textoServicios.append("\n")
            }
            textoRespuestas.append(textoServicios)
        }

        // Establecer el texto en el TextView
        binding.tvrespuestas.text = textoRespuestas.toString()
    }
}


