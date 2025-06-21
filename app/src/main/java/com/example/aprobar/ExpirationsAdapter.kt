package com.example.aprobar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExpirationsAdapter(private val expirations: List<ExpirationsData>) : RecyclerView.Adapter<ExpirationsAdapter.ExpirationsViewHolder>() {

    // Definir elementos a usar en cada item
    class ExpirationsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val expirationsSubject: TextView = itemView.findViewById(R.id.expirations_subject)
        val expirationsDays: TextView = itemView.findViewById(R.id.expirations_days)
        val expirationsType: TextView = itemView.findViewById(R.id.expirations_type)
        val expirationsDate: TextView = itemView.findViewById(R.id.expirations_date)
    }

    // Crear e inflar item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpirationsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_expirations, parent, false)
        return ExpirationsViewHolder(view)
    }

    // Asignar datos a cada ítem
    override fun onBindViewHolder(holder: ExpirationsViewHolder, position: Int) {
        val item = expirations[position]

        holder.expirationsSubject.text = item.subject
        holder.expirationsType.text = item.type
        holder.expirationsDate.text = item.date
        setDays(item.date, holder.expirationsDays, holder.itemView.context)
    }

    // Definir cantidad de items
    override fun getItemCount(): Int = expirations.size
}

