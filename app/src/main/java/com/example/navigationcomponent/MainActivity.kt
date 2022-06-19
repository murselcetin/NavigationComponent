package com.example.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.navigationcomponent.databinding.BottomSayfaBinding
import com.example.navigationcomponent.databinding.DrawerSayfaBinding

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim: DrawerSayfaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DrawerSayfaBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(tasarim.navigationView, navHostFragment.navController)

        tasarim.toolbar.title = "Başlık"

        val toogle = ActionBarDrawerToggle(this, tasarim.drawer, tasarim.toolbar, 0, 0)
        tasarim.drawer.addDrawerListener(toogle)
        toogle.syncState()

        val baslik = tasarim.navigationView.inflateHeaderView(R.layout.navigation_baslik)
        val textViewBaslik = baslik.findViewById(R.id.textViewBaslik) as TextView
        textViewBaslik.text = "Merhaba"
    }

    override fun onBackPressed() {
        if (tasarim.drawer.isDrawerOpen(GravityCompat.START)) {
            tasarim.drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}