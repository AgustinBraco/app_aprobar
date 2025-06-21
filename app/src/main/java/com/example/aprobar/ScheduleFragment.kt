package com.example.aprobar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener datos mockeados
        val schedule = sharedViewModel.schedule

        // Configurar para mostrar lista de items
        val recyclerView = view.findViewById<RecyclerView>(R.id.schedule_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ScheduleAdapter(schedule)
    }
}