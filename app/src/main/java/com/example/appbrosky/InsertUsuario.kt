package com.example.appbrosky

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class InsertUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_usuario)
        var guardar : TextView = findViewById(R.id.editTextTextPersonName)
        guardar.setText(intent.extras?.getString("name"))

    }



    fun guardo(view : View){
        var guardar : TextView = findViewById(R.id.editTextTextPersonName)
        val db : UsersDBHelper = UsersDBHelper(this)
        db.insertUser(UserModel(intent.extras?.getString("Genero")+" "+guardar.text.toString() ,
            intent.extras?.getString("fecha").toString()
        ))

        Toast.makeText(applicationContext,"Se ha guardado todo correctamente",Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java).apply {

        }
        startActivity(intent)
    }

}