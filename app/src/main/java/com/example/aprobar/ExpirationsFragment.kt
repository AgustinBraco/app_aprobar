package com.example.aprobar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExpirationsFragment : Fragment(R.layout.fragment_expirations) {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener datos mockeados
        val expirations = sharedViewModel.expirations

        // Configurar para mostrar lista de items
        val recyclerView = view.findViewById<RecyclerView>(R.id.expirations_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ExpirationsAdapter(expirations)
    }
}