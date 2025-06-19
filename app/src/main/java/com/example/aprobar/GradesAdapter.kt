package com.example.aprobar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class GradesAdapter(private val grades: List<GradesData>) : RecyclerView.Adapter<GradesAdapter.GradesViewHolder>() {

    class GradesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSubject = itemView.findViewById<TextView>(R.id.grades_subject)
        val tvStatus = itemView.findViewById<TextView>(R.id.grades_status)
        val tvType = itemView.findViewById<TextView>(R.id.grades_type)
        val tvGrade = itemView.findViewById<TextView>(R.id.grades_grade)
        val tvDate = itemView.findViewById<TextView>(R.id.grades_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GradesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grades, parent, false)
        return GradesViewHolder(view)
    }

    override fun onBindViewHolder(holder: GradesViewHolder, position: Int) {
        val grade = grades[position]
        holder.tvSubject.text = grade.subject
        holder.tvType.text = grade.type
        holder.tvGrade.text = grade.grade
        holder.tvDate.text = grade.date

        val gradeNum = holder.tvGrade.text.toString().trim().toDouble()
        when {
            gradeNum >= 7 -> {
                holder.tvStatus.text = "Promocionado"
                holder.tvStatus.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.style_rounded_green)
            }
            gradeNum >= 6 -> {
                holder.tvStatus.text = "Zona de promoción"
                holder.tvStatus.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.style_rounded_yellow)
            }
            gradeNum >= 4 -> {
                holder.tvStatus.text = "Regular"
                holder.tvStatus.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.style_rounded_orange)
            }
            else -> {
                holder.tvStatus.text = "Libre"
                holder.tvStatus.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.style_rounded_red)
            }
        }
    }

    override fun getItemCount(): Int = grades.size
}

