package com.example.aprobar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GradesFragment : Fragment(R.layout.fragment_grades) {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener datos mockeados
        val grades = sharedViewModel.grades

        // Configurar para mostrar lista de items
        val recyclerView = view.findViewById<RecyclerView>(R.id.grades_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = GradesAdapter(grades)
    }
}