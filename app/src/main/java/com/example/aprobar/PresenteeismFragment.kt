package com.example.aprobar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PresenteeismFragment : Fragment(R.layout.fragment_presenteeism) {
    private lateinit var sharedViewModel: SharedViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Obtener el ViewModel
        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        // 2. Ejecutar la función que carga los datos (mock)
        sharedViewModel.loadPresenteeism()

        // 3. Obtener RecyclerView y configurarlo
        val recyclerView = view.findViewById<RecyclerView>(R.id.presenteeism_recycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // 4. Observar los datos del ViewModel y actualizar el adapter
        sharedViewModel.presenteeismShared.observe(viewLifecycleOwner) { presenteeismList ->
            recyclerView.adapter = PresenteeismAdapter(presenteeismList)

        }
    }

}

