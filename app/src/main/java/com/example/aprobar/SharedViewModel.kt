package com.example.aprobar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    // Encapsular el MutableLiveData
    private val _presenteeismShared = MutableLiveData<List<PresenteeismData>>()
    val presenteeismShared: LiveData<List<PresenteeismData>> = _presenteeismShared

    // Función para cargar los datos (mock en este caso)
    fun loadPresenteeism() {
        val data = listOf(
            PresenteeismData("PPI", 8, 2),
            PresenteeismData("Met. Pruebas de Sistemas", 14, 3),
            PresenteeismData("Base de Datos", 10, 1),
            PresenteeismData("Estadística y Probabilidad", 10, 0),
            PresenteeismData("POO", 14, 4),
            PresenteeismData("Taller de Comunicación", 0, 2)
        )
        _presenteeismShared.value = data
    }
}