package com.example.aprobar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GradesAdapter(private val grades: List<GradesData>) : RecyclerView.Adapter<GradesAdapter.GradesViewHolder>() {

    // Definir elementos a usar en cada item
    class GradesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gradesSubject: TextView = itemView.findViewById(R.id.grades_subject)
        val gradesStatus: TextView = itemView.findViewById(R.id.grades_status)
        val gradesType: TextView = itemView.findViewById(R.id.grades_type)
        val gradesGrade: TextView = itemView.findViewById(R.id.grades_grade)
        val gradesDate: TextView = itemView.findViewById(R.id.grades_date)
    }

    // Crear e inflar item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grades, parent, false)
        return GradesViewHolder(view)
    }

    // Asignar datos a cada ítem
    override fun onBindViewHolder(holder: GradesViewHolder, position: Int) {
        val item = grades[position]

        holder.gradesSubject.text = item.subject
        holder.gradesType.text = item.type
        holder.gradesGrade.text = item.grade
        holder.gradesDate.text = item.date
        setStatus(item.grade, holder.gradesStatus, holder.itemView.context)
    }

    // Definir cantidad de items
    override fun getItemCount(): Int = grades.size
}
