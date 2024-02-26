package com.example.evc02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.evc02.databinding.ItemListaBinding

class AdapterLista(private var lstConciertos: List<List<String>>) : RecyclerView.Adapter<AdapterLista.ViewHolder>() {
    inner class ViewHolder(val binding: ItemListaBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListaBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = lstConciertos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val concierto = lstConciertos[position]
        holder.binding.tvNombre.text = concierto[0]  // Nombre
        holder.binding.tvDescripcion.text = concierto[1]  // Descripción
        holder.binding.tvFecha.text = concierto[2]  // Fecha
    }
}