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
        val checkBox1 = intent.getBooleanExtra("checkBox1", false)
        val checkBox2 = intent.getBooleanExtra("checkBox2", false)
        val checkBox3 = intent.getBooleanExtra("checkBox3", false)
        val checkBox4 = intent.getBooleanExtra("checkBox4", false)
        val radioButtonSeleccionado = intent.getStringExtra("radioButtonSeleccionado")

        // STRING CON TODA LA INFO
        val informacion = """
            Nombre: $nombre
            Apellidos: $apellidos
            DNI: $dni
            Celular: $celular
            Email: $email
            CheckBox 1: ${checkBox1.toString()}
            CheckBox 2: ${checkBox2.toString()}
            CheckBox 3: ${checkBox3.toString()}
            CheckBox 4: ${checkBox4.toString()}
            RadioButton Seleccionado: $radioButtonSeleccionado
        """.trimIndent()

        // MOSTRAR INFO EN EL TEXTVIEW
        binding.tvinformacion.text = informacion
    }
}