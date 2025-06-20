package com.example.aprobar

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExpirationsFragment : Fragment(R.layout.fragment_expirations) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mockear datos
        val expirations = listOf(
            ExpirationsData("Testing", "Parcial", getFutureDate(0)),
            ExpirationsData("Matemáticas", "Parcial", getFutureDate(1)),
            ExpirationsData("Base de Datos", "Trabajo Práctico",getFutureDate(6)),
            ExpirationsData("POO", "Parcial", getFutureDate(12)),
            ExpirationsData("PPII", "Final", getFutureDate(20)),
            ExpirationsData("Lógica", "Trabajo Práctico", getPastDate(3)),
            ExpirationsData("Inglés", "Final", getPastDate(7))
        )

        // Configurar para mostrar lista de items
        val recyclerView = view.findViewById<RecyclerView>(R.id.expirations_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ExpirationsAdapter(expirations)
    }
}