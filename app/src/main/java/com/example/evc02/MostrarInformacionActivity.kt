package com.example.evc02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.evc02.databinding.ActivityMostrarInformacionBinding

class MostrarInformacionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMostrarInformacionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostrarInformacionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // OBTENER DATOS DE ACTIVIDAD REGISTRO
        val nombre = intent.getStringExtra("nombre")
        val apellidos = intent.getStringExtra("apellidos")
        val dni = intent.getStringExtra("dni")
        val celular = intent.getStringExtra("celular")
        val email = intent.getStringExtra("email")
        val checkboxSeleccionadosArray = intent.getStringArrayExtra("checkboxSeleccionado")
        val radioButtonSeleccionado = intent.getStringExtra("radioButtonSeleccionado")

        // Convertir el array de opciones de CheckBox a una cadena
        val checkboxSeleccionados = checkboxSeleccionadosArray?.joinToString(", ") ?: ""

        // STRING CON TODA LA INFO
        val informacion = """
        Nombre: $nombre
        Apellidos: $apellidos
        DNI: $dni
        Celular: $celular
        Email: $email
        Programas que domina: $checkboxSeleccionados
        Color Favorito: $radioButtonSeleccionado
    """.trimIndent()

        // MOSTRAR INFO EN EL TEXTVIEW
        binding.tvinformacion.text = informacion

    }
}