package com.example.mentalhealth.activities

import com.example.mentalhealth.AlarmaFragment
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.mentalhealth.AgendaFragment
import com.example.mentalhealth.BienestarFragment
import com.example.mentalhealth.CemoncionesFragment
import com.example.mentalhealth.DiarioFragment
import com.example.mentalhealth.EfectosSecFragment
import com.example.mentalhealth.InfoDiagFragment
import com.example.mentalhealth.MedicFragment
import com.example.mentalhealth.MindFragment
import com.example.mentalhealth.PerfilFragment
import com.example.mentalhealth.R
import com.example.mentalhealth.SoporteFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var exampleText: TextView
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setupViews()
        setupToolbar()

        // Habilitar el botón de navegación (hamburguesa)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Manejar la selección de elementos en el NavigationView
        navigationView.setNavigationItemSelectedListener { item ->
            handleNavigationItemSelected(item.itemId)
        }

        // Manejar la selección de elementos en el BottomNavigationView
        bottomNavigation.setOnItemSelectedListener { item ->
            handleBottomNavigationItemSelected(item.itemId)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Abre el Navigation Drawer cuando se hace clic en el botón de navegación
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
            // Agrega más casos según sea necesario
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun setupViews() {
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        exampleText = findViewById(R.id.example_text)
    }

    private fun setupToolbar() {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    // Manejar la selección de elementos en el NavigationView
    private fun handleNavigationItemSelected(itemId: Int): Boolean {
        when (itemId) {
            R.id.nav_item1 -> {
                changeFragment(PerfilFragment())
                closeDrawer()
                return true
            }
            R.id.nav_item2 -> {
                changeFragment(AgendaFragment())
                closeDrawer()
                return true
            }
            R.id.nav_item3 -> {
                changeFragment(AlarmaFragment())
                closeDrawer()
                return true
            }

            R.id.nav_item5 -> {
                changeFragment(MedicFragment())
                closeDrawer()
                return true
            }
            R.id.page_8 -> {
                changeFragment(InfoDiagFragment())
                closeDrawer()
                return true
            }
            R.id.nav_item7 -> {
                changeFragment(SoporteFragment())
                closeDrawer()
                return true
            }
            // Agrega más casos según sea necesario
            else -> return false
        }
    }

    // Manejar la selección de elementos en el BottomNavigationView
    private fun handleBottomNavigationItemSelected(itemId: Int): Boolean {
        when (itemId) {
            R.id.page_1 -> {
                changeFragment(BienestarFragment())
                closeDrawer()
                return true
            }
            R.id.page_2 -> {
                changeFragment(DiarioFragment())
                closeDrawer()
                return true
            }
            R.id.page_3 -> {
                changeFragment(MindFragment())
                closeDrawer()
                return true
            }
            R.id.page_4 -> {
                changeFragment(CemoncionesFragment())
                closeDrawer()
                return true
            }
            R.id.nav_item5 -> {
                changeFragment(EfectosSecFragment())
                closeDrawer()
                return true
            }
            else -> return false
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Puedes manejar la selección de elementos del NavigationView aquí si es necesario
        return false
    }

    private fun closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    fun changeFragment(frag: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, frag)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}
