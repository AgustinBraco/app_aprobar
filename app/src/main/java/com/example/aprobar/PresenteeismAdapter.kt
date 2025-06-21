package com.example.aprobar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PresenteeismAdapter(private val presenteeism: List<PresenteeismData>) : RecyclerView.Adapter<PresenteeismAdapter.PresenteeismViewHolder>() {

    // Definir elementos a usar en cada item
    class PresenteeismViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val presenteeismSubject: TextView = itemView.findViewById(R.id.presenteeism_subject)
        val presenteeismPercentage: TextView = itemView.findViewById(R.id.presenteeism_percentage)
        val presenteeismPresent: TextView = itemView.findViewById(R.id.presenteeism_present)
        val presenteeismAbsent: TextView = itemView.findViewById(R.id.presenteeism_absent)
    }

    // Crear e inflar item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresenteeismViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_presenteeism, parent, false)
        return PresenteeismViewHolder(view)
    }

    // Asignar datos a cada ítem
    override fun onBindViewHolder(holder: PresenteeismViewHolder, position: Int) {
        val presenteeismSubject = presenteeism[position]
        holder.presenteeismSubject.text = presenteeismSubject.subject
        holder.presenteeismPresent.text = presenteeismSubject.present.toString()
        holder.presenteeismAbsent.text = presenteeismSubject.absent.toString()

        val presenteeismPercentage = calculatePresenteeism(presenteeismSubject.present, presenteeismSubject.absent)
        holder.presenteeismPercentage.text = "$presenteeismPercentage%"
    }

    // Definir cantidad de items
    override fun getItemCount(): Int = presenteeism.size
}

