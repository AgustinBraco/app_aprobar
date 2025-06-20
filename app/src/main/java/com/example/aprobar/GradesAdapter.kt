package com.example.aprobar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GradesAdapter(private val grades: List<GradesData>) : RecyclerView.Adapter<GradesAdapter.GradesViewHolder>() {

    // Definir elementos a usar en cada item
    class GradesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSubject: TextView = itemView.findViewById(R.id.grades_subject)
        val tvStatus: TextView = itemView.findViewById(R.id.grades_status)
        val tvType: TextView = itemView.findViewById(R.id.grades_type)
        val tvGrade: TextView = itemView.findViewById(R.id.grades_grade)
        val tvDate: TextView = itemView.findViewById(R.id.grades_date)
    }

    // Crear e inflar item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grades, parent, false)
        return GradesViewHolder(view)
    }

    // Asignar datos a cada ítem
    override fun onBindViewHolder(holder: GradesViewHolder, position: Int) {
        val grade = grades[position]
        holder.tvSubject.text = grade.subject
        holder.tvType.text = grade.type
        holder.tvGrade.text = grade.grade
        holder.tvDate.text = grade.date

        setStatus(
            holder.tvGrade.text.toString(),
            holder.tvStatus,
            holder.itemView.context
        )
    }

    // Definir cantidad de items
    override fun getItemCount(): Int = grades.size
}

