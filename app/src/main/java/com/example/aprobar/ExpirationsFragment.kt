package com.example.aprobar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExpirationsFragment : Fragment(R.layout.fragment_expirations) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mockear datos
        val previousDays = getPreviousDays(7)
        val nextDays = getNextDays(20)

        val expirations = listOf(
            ExpirationsData("Testing", "Parcial", nextDays[0]),
            ExpirationsData("Matemáticas", "Parcial", nextDays[1]),
            ExpirationsData("Base de Datos", "Trabajo Práctico", nextDays[6]),
            ExpirationsData("POO", "Parcial", nextDays[12]),
            ExpirationsData("PPII", "Final", nextDays[20]),
            ExpirationsData("Lógica", "Trabajo Práctico", previousDays[3]),
            ExpirationsData("Inglés", "Final", previousDays[7])
        )

        // Configurar para mostrar lista de items
        val recyclerView = view.findViewById<RecyclerView>(R.id.expirations_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ExpirationsAdapter(expirations)
    }
}