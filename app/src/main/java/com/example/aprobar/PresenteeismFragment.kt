package com.example.aprobar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.activityViewModels

class PresenteeismFragment : Fragment(R.layout.fragment_presenteeism) {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener datos mockeados
        val presenteeism = sharedViewModel.presenteeism

        // Configurar para mostrar lista de items
        val recyclerView = view.findViewById<RecyclerView>(R.id.presenteeism_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = PresenteeismAdapter(presenteeism)
    }
}
