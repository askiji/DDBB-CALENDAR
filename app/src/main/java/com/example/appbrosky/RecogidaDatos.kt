package com.example.appbrosky

import android.app.DatePickerDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.*

class RecogidaDatos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recogida_datos)
        val generos = resources.getStringArray(R.array.Genero)
        val spinner: Spinner = findViewById(R.id.spinner)

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, generos
            )
            spinner.adapter = adapter
        }
    }


    @RequiresApi(Build.VERSION_CODES.N)
    fun calendario(view: View) {
        var cal = Calendar.getInstance()

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val texto: TextView = findViewById(R.id.textView2)
                val myFormat = "dd/MM/yyyy" // mention the format you need
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                texto!!.setText( sdf.format(cal.getTime()))
            }
        }

        DatePickerDialog(this,
            dateSetListener,
            // set DatePickerDialog to point to today's date when it loads up
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH)).show()



    }


    fun confirmar(view: View) {
        var texto: TextView = findViewById(R.id.editTextTextPersonName2)
        val texto1: TextView = findViewById(R.id.textView2)
        val genero : Spinner = findViewById(R.id.spinner)
        val bundle = Bundle()
        bundle.putString("name", texto.text.toString())
        bundle.putString("fecha", texto1.text.toString())
        bundle.putString("Genero" , genero.selectedItem.toString())
        Log.d("Genero" , genero.toString())
        val intent = Intent(this, InsertUsuario::class.java).apply {

        }
        intent.putExtras(bundle)

        startActivity(intent)
    }

}
