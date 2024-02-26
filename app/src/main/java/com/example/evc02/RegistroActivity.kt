package com.example.evc02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.evc02.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity() {

    private lateinit var binding:ActivityRegistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //
        binding.btnacceder.setOnClickListener {
            // VALIDANDO CAMPOS
            if (validarCampos()) {
                // OBTENIENDO DATOS INGRESADOS
                val nombre = binding.etnombre.text.toString()
                val apellidos = binding.etapellidos.text.toString()
                val dni = binding.etdni.text.toString()
                val celular = binding.etcelular.text.toString()
                val email = binding.etemail.text.toString()
                val checkboxSeleccionado = obtenerCheckBoxSeleccionados()
                val radioButtonSeleccionado = obtenerRadioButtonSeleccionado()

                // PASANDO DATOS A MOSTRARINFOACTIVITY
                val intent = Intent(this, MostrarInformacionActivity::class.java).apply {
                    putExtra("nombre", nombre)
                    putExtra("apellidos", apellidos)
                    putExtra("dni", dni)
                    putExtra("celular", celular)
                    putExtra("email", email)
                    putExtra("checkboxSeleccionado", obtenerCheckBoxSeleccionados())
                    putExtra("radioButtonSeleccionado", obtenerRadioButtonSeleccionado())
                }
                startActivity(intent)
            } else {
                // MENSAJE DE ERROR SI NO SE COMPLETO TODOS LOS CAMPOS
                Toast.makeText(this, "Por favor complete todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validarCampos(): Boolean {
        // VERIFICACION DE LAS CAJAS DE TEXTO
        return binding.etnombre.text.isNotEmpty() &&
                binding.etapellidos.text.isNotEmpty() &&
                binding.etdni.text.isNotEmpty() &&
                binding.etcelular.text.isNotEmpty() &&
                binding.etemail.text.isNotEmpty()
    }

    private fun obtenerRadioButtonSeleccionado(): String {
        // OBTENIENDO EL ID DEL RADIO BUTTON QUE SE SELECCIONE
        val radioButtonId = binding.rgcolores.checkedRadioButtonId
        // RETORNANDO EL TEXTO DEL ID QUE SE SELECCIONE
        return when (radioButtonId) {
            R.id.rbazul -> "Azul"
            R.id.rbrojo -> "Rojo"
            R.id.rbverde -> "Verde"
            R.id.rbotro -> "Otro"
            else -> "No se selecciono ninguna opcion"
        }
    }

    private fun obtenerCheckBoxSeleccionados(): Array<String> {
        val checkBoxSeleccionados = mutableListOf<String>()

        if (binding.cbsqlserver.isChecked) {
            checkBoxSeleccionados.add(binding.cbsqlserver.text.toString())
        }
        if (binding.cbstudiocode.isChecked) {
            checkBoxSeleccionados.add(binding.cbstudiocode.text.toString())
        }
        if (binding.cbandroidstudio.isChecked) {
            checkBoxSeleccionados.add(binding.cbandroidstudio.text.toString())
        }
        if (binding.cbotro.isChecked) {
            checkBoxSeleccionados.add(binding.cbotro.text.toString())
        }

        return checkBoxSeleccionados.toTypedArray()
    }


}
