package com.example.aprobar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Aplicar margen superior dinámico
        val homeLayout = findViewById<ConstraintLayout>(R.id.home)
        ViewCompat.setOnApplyWindowInsetsListener(homeLayout) { view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars())
            view.updatePadding(top = insets.top)
            windowInsets
        }

        // Sección Home por defecto
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragments, HomeFragment())
            .commit()

        // Menú
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer)
        val navView = findViewById<NavigationView>(R.id.menu)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Alternar estado del menú
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.drawer_open, R.string.drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Acciones del menú
        navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_home -> replaceFragment(HomeFragment())
                R.id.menu_grades -> replaceFragment(GradesFragment())
                R.id.menu_expirations -> replaceFragment(ExpirationsFragment())
                R.id.menu_schedule -> replaceFragment(ScheduleFragment())
                R.id.menu_presenteeism -> replaceFragment(PresenteeismFragment())
                R.id.menu_about -> replaceFragment(AboutFragment())
                R.id.menu_logout -> {
                    val mainIntent = Intent(this, MainActivity::class.java)
                    startActivity(mainIntent)
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    // Renderizar sección seleccionada
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragments, fragment)
            .addToBackStack(null)
            .commit()
    }
}