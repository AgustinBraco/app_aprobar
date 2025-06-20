package com.example.aprobar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GradesFragment : Fragment(R.layout.fragment_grades) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mockear datos
        val previousDays = getPreviousDays(20)

        val grades = listOf(
            GradesData("Base de Datos", "Parcial", "8.5", previousDays[1]),
            GradesData("POO","Trabajo Práctico", "6", previousDays[2]),
            GradesData("PPI", "Parcial", "4.5", previousDays[5]),
            GradesData("Testing", "Parcial", "5.5", previousDays[9]),
            GradesData("Matemáticas","Final", "2", previousDays[11]),
            GradesData("Lógica","Trabajo Práctico", "7", previousDays[18]),
            GradesData("TICS","Trabajo Práctico", "6.5", previousDays[20])
        )

        // Configurar para mostrar lista de items
        val recyclerView = view.findViewById<RecyclerView>(R.id.grades_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = GradesAdapter(grades)
    }
}