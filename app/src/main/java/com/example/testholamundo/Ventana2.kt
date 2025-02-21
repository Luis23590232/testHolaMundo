package com.example.testholamundo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ventana2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var bundle = intent.extras
        var respuesta = bundle?.getStringArray("respuesta")

        val txtnombre = findViewById<TextView>(R.id.txtNombre)
        val txtnControl = findViewById<TextView>(R.id.txtnControl)
        val txtfecha = findViewById<TextView>(R.id.txtFecha)
        val txtcarrera = findViewById<TextView>(R.id.txtCarrera)
        val txtsemestre = findViewById<TextView>(R.id.txtSemestre)
        val txtcurp = findViewById<TextView>(R.id.txtCURP)
        val txtrfc = findViewById<TextView>(R.id.txtRFC)
        val txttelefono = findViewById<TextView>(R.id.txtTelefono)
        val txtemail = findViewById<TextView>(R.id.txtEmail)
        val txtdireccion = findViewById<TextView>(R.id.txtDireccion)

        val Volver = findViewById<Button>(R.id.btnVolver)

        txtnombre.text = "Nombre: " + respuesta?.get(0)
        txtnControl.text = "No. Control: " + respuesta?.get(1)
        txtfecha.text = "Fecha: " + respuesta?.get(2)
        txtcarrera.text = "Carrera: " + respuesta?.get(3)
        txtsemestre.text = "Semestre: " + respuesta?.get(4)
        txtcurp.text = "CURP: " + respuesta?.get(5)
        txtrfc.text = "RFC: " + respuesta?.get(6)
        txttelefono.text = "Telefono: " + respuesta?.get(7)
        txtemail.text = "Email: " + respuesta?.get(8)
        txtdireccion.text = "Direccion: " + respuesta?.get(9)

        Volver.setOnClickListener {
            finish()
        }
    }
}