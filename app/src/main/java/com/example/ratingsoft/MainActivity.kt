package com.example.ratingsoft

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import com.example.ratingsoft.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Llama a la función showSplashScreen después de la creación de la actividad
        showSplashScreen()
    }

    private fun showSplashScreen() {
        // Cambia la vista a la pantalla de inicio (activity_splash.xml)
        setContentView(R.layout.activity_splash)

        // Temporizador para la pantalla de inicio
        Handler().postDelayed({
            // Inicia la actividad principal después del tiempo especificado
            startActivity(Intent(this, Login1_activity::class.java)) //aqui crear menu para que pase alla
            finish() // Cierra la actividad actual para evitar volver a la pantalla de inicio
        }, 2000) // 2000 milisegundos (2 segundos) de tiempo de espera
    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_main, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.menu_option1 -> {
//                // Acciones para la opción 1
//                return true
//            }
//            R.id.menu_option2 -> {
//                // Acciones para la opción 2
//                return true
//            }
//            R.id.menu_option3 -> {
//                // Acciones para la opción 3
//                return true
//            }
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }

}