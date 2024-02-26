package com.example.evc02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.evc02.databinding.ActivityCuestionarioBinding

class CuestionarioActivity : AppCompatActivity() {

    private lateinit var binding:ActivityCuestionarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCuestionarioBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Agregar listener de clic al botón "Resolver"
        binding.btnresolver.setOnClickListener {
            // Validar campos
            if (validarCampos()) {
                // Obtener datos ingresados
                val respuestasPregunta1 = obtenerRespuestasPregunta1()
                val opcionSeleccionadaPregunta2 = obtenerOpcionSeleccionadaPregunta2()
                val opcionSeleccionadaPregunta3 = obtenerOpcionSeleccionadaPregunta3()
                val opcionSeleccionadaPregunta4 = obtenerOpcionSeleccionadaPregunta4()
                val respuestasPregunta5 = obtenerRespuestasPregunta5()

                // Aquí puedes realizar la lógica adicional que necesites con las respuestas del formulario

                // Por ejemplo, podrías mostrar las respuestas en la siguiente actividad
                mostrarRespuestasEnNuevaActividad(respuestasPregunta1, opcionSeleccionadaPregunta2,
                    opcionSeleccionadaPregunta3, opcionSeleccionadaPregunta4, respuestasPregunta5)
            } else {
                // Mostrar mensaje de error si algún campo está vacío
                Toast.makeText(this, "Por favor complete todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validarCampos(): Boolean {
        // Verificar que todos los campos estén completos
        // Aquí puedes agregar la lógica de validación para cada pregunta
        return true // Reemplazar con la lógica de validación adecuada
    }

    private fun obtenerRespuestasPregunta1(): List<Boolean> {
        // Obtener el estado de los CheckBox de la pregunta 1
        val respuestas = mutableListOf<Boolean>()
        respuestas.add(binding.cbgusto.isChecked)
        respuestas.add(binding.cbtos.isChecked)
        respuestas.add(binding.cbgarganta.isChecked)
        respuestas.add(binding.cbnasal.isChecked)
        respuestas.add(binding.cbfiebre.isChecked)
        respuestas.add(binding.cbninguno.isChecked)
        return respuestas
    }

    private fun obtenerOpcionSeleccionadaPregunta2(): String {
        // Obtener la opción seleccionada de la pregunta 2
        val idSeleccionado = binding.rggrados.checkedRadioButtonId
        return if (idSeleccionado != -1) {
            val radioButtonSeleccionado = findViewById<RadioButton>(idSeleccionado)
            radioButtonSeleccionado.text.toString()
        } else {
            "" // Enviar cadena vacía si no se selecciona ninguna opción
        }
    }

    private fun obtenerOpcionSeleccionadaPregunta3(): String {
        // Obtener la opción seleccionada de la pregunta 3
        val idSeleccionado = binding.rgvivir.checkedRadioButtonId
        return if (idSeleccionado != -1) {
            val radioButtonSeleccionado = findViewById<RadioButton>(idSeleccionado)
            radioButtonSeleccionado.text.toString()
        } else {
            "" // Enviar cadena vacía si no se selecciona ninguna opción
        }
    }

    private fun obtenerOpcionSeleccionadaPregunta4(): String {
        // Obtener la opción seleccionada de la pregunta 4
        val idSeleccionado = binding.rgmayor.checkedRadioButtonId
        return if (idSeleccionado != -1) {
            val radioButtonSeleccionado = findViewById<RadioButton>(idSeleccionado)
            radioButtonSeleccionado.text.toString()
        } else {
            "" // Enviar cadena vacía si no se selecciona ninguna opción
        }
    }

    private fun obtenerRespuestasPregunta5(): List<Boolean> {
        // Obtener el estado de los CheckBox de la pregunta 5
        val respuestas = mutableListOf<Boolean>()
        respuestas.add(binding.cbluz.isChecked)
        respuestas.add(binding.cbagua.isChecked)
        respuestas.add(binding.cbinternet.isChecked)
        respuestas.add(binding.cbcable.isChecked)
        return respuestas
    }

    private fun mostrarRespuestasEnNuevaActividad(respuestasPregunta1: List<Boolean>, opcionSeleccionadaPregunta2: String,
                                                  opcionSeleccionadaPregunta3: String, opcionSeleccionadaPregunta4: String,
                                                  respuestasPregunta5: List<Boolean>) {
        // Pasar datos a la siguiente actividad para mostrar las respuestas
        val intent = Intent(this, MostrarRespuestasActivity::class.java).apply {
            putExtra("respuestasPregunta1", respuestasPregunta1.toBooleanArray())
            putExtra("opcionSeleccionadaPregunta2", opcionSeleccionadaPregunta2)
            putExtra("opcionSeleccionadaPregunta3", opcionSeleccionadaPregunta3)
            putExtra("opcionSeleccionadaPregunta4", opcionSeleccionadaPregunta4)
            putExtra("respuestasPregunta5", respuestasPregunta5.toBooleanArray())
        }
        startActivity(intent)
    }

    private fun validarCheckBox(): Boolean {
        // Verificar que al menos un CheckBox esté seleccionado
        return binding.cbgusto.isChecked ||
                binding.cbgarganta.isChecked ||
                binding.cbtos.isChecked ||
                binding.cbnasal.isChecked ||
                binding.cbfiebre.isChecked ||
                binding.cbninguno.isChecked
    }
}