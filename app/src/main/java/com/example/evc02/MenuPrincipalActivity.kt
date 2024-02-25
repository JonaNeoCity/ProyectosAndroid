package com.example.evc02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.evc02.databinding.ActivityMenuPrincipalBinding

class MenuPrincipalActivity : AppCompatActivity() {
   // VIEW BINDING
    private lateinit var binding: ActivityMenuPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //LLAMANDO A LAS VENTANAS DE INTERFAZ
        binding.btnregistro.setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
        }

        binding.btnformulario.setOnClickListener {
            startActivity(Intent(this, CuestionarioActivity::class.java))
        }

        binding.btnlistado.setOnClickListener {
         val listado = AdapterLista()
        }
   }
}