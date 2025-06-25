package com.example.aprobar

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener elementos
        val profileName: TextView = view.findViewById(R.id.profile_name)
        val profileLastname: TextView = view.findViewById(R.id.profile_lastname)
        val profileDNI: TextView = view.findViewById(R.id.profile_dni)
        val profileAge: TextView = view.findViewById(R.id.profile_age)
        val profileGender: TextView = view.findViewById(R.id.profile_gender)
        val profileCareer: TextView = view.findViewById(R.id.profile_career)

        // Obtener datos mockeados
        val profile = sharedViewModel.profile
        val dni = (activity as? HomeActivity)?.dni ?: ""

        // Asignar datos
        profileName.text = profile.name
        profileLastname.text = profile.lastname
        profileDNI.text = dni
        profileAge.text = profile.age.toString()
        profileGender.text = profile.gender
        profileCareer.text = profile.career
    }
}