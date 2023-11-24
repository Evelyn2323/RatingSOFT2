package com.example.ratingsoft.ui.Calendario

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ratingsoft.R
import java.util.*

class Calendario : AppCompatActivity() {

    private lateinit var editTextFecha: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.datos_personales)

        editTextFecha = findViewById(R.id.editTextFecha)

        // Configurar el DatePickerDialog
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { view: DatePicker?, selectedYear: Int, monthOfYear: Int, dayOfMonth: Int ->
                // Actualizar el EditText con la fecha seleccionada
                editTextFecha.setText("$dayOfMonth/${monthOfYear + 1}/$selectedYear")
            },
            year, month, day
        )

        // Mostrar el DatePickerDialog cuando el EditText sea clicado
        editTextFecha.setOnClickListener {
            datePickerDialog.show()
        }
    }
}