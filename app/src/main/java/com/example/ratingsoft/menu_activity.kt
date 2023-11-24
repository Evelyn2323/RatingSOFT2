package com.example.ratingsoft

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ratingsoft.databinding.ActivityMenuBinding
import com.google.android.material.navigation.NavigationView


    class menu_activity : AppCompatActivity() {

        private lateinit var appBarConfiguration: AppBarConfiguration
        private lateinit var binding: ActivityMenuBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding = ActivityMenuBinding.inflate(layoutInflater)
            setContentView(binding.root)

            setSupportActionBar(binding.appBarMenu.toolbar)



            /*binding.appBarMenu.fab.setOnClickListener { view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }*/


            val drawerLayout: DrawerLayout = binding.drawerLayout
            val navView: NavigationView = binding.navView
            val navController = findNavController(R.id.nav_host_fragment_content_menu)
            // Passing each menu ID as a set of Ids because each
            // menu should be considered as top level destinations.
            appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.nav_home, R.id.edit, R.id.nav_slideshow1, R.id.Comentario,R.id.Descargar
                ), drawerLayout
            )


            setupActionBarWithNavController(navController, appBarConfiguration)
            navView.setupWithNavController(navController)


        }


        override fun onCreateOptionsMenu(menu: Menu): Boolean {
            // Inflate the menu; this adds items to the action bar if it is present.
            menuInflater.inflate(R.menu.activity_main_menu, menu)
            return true
        }

        override fun onSupportNavigateUp(): Boolean {
            val navController = findNavController(R.id.nav_host_fragment_content_menu)
            return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
        }





    }