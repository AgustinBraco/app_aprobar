package com.example.aprobar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GradesFragment : Fragment(R.layout.fragment_grades) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val grades = listOf(
            GradesData("Adm. de Base de Datos", "Parcial", "8.5", "01/07/2025"),
            GradesData("POO","Trabajo Práctico", "6", "25/06/2025"),
            GradesData("PPI", "Parcial", "4.5", "18/06/2025"),
            GradesData("Matemática","Final", "2", "16/06/2025"),
            GradesData("Taller de Comunicación","Trabajo Práctico", "7", "09/06/2025"),
            GradesData("TICS","Trabajo Práctico", "6.5", "09/06/2025")
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = GradesAdapter(grades)
    }
}