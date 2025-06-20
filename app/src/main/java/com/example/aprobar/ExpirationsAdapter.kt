package com.example.aprobar

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
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
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ExpirationsViewHolder, position: Int) {
        val expiration = expirations[position]
        holder.expirationsSubject.text = expiration.subject
        holder.expirationsType.text = expiration.type
        holder.expirationsDate.text = expiration.date

        setDays(
            holder.expirationsDate.text.toString(),
            holder.expirationsDays,
            holder.itemView.context
        )
    }

    // Definir cantidad de items
    override fun getItemCount(): Int = expirations.size
}

