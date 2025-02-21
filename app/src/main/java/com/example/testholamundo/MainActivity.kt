package com.example.testholamundo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var spinner: Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        spinner = findViewById(R.id.spinnerCarrera)
        val elementos = listOf("Elige una opcion","Ing. Industrial", "Ing. Electromecanica", "Ing. en Gestion Emresarial", "Ing. en Sistemas Computacionales", "Ing. en TICS")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, elementos)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val elementoSeleccionado = elementos[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Manejar cuando no hay selección
            }
        }

        enviarDatos()

    }

    fun enviarDatos() {
        val nombre = findViewById<EditText>(R.id.Nombre)
        val curp = findViewById<EditText>(R.id.CURP)
        val rfc = findViewById<EditText>(R.id.RFC)
        val direccion = findViewById<EditText>(R.id.Direccion)
        val nControl = findViewById<EditText>(R.id.N_Control)
        val nSemestre = findViewById<EditText>(R.id.N_Semestre)
        val nTelefono = findViewById<EditText>(R.id.N_Telefono)
        val email = findViewById<EditText>(R.id.Email)
        val fecha_nac = findViewById<EditText>(R.id.Fecha_Nac)

        val btnEnviar = findViewById<Button>(R.id.btnEnviar)

        btnEnviar.setOnClickListener {
            val intent = Intent(this, Ventana2::class.java)
            if (nombre.text.toString().isNotEmpty() && curp.text.toString().isNotEmpty() && rfc.text.toString().isNotEmpty() && direccion.text.toString().isNotEmpty() && nControl.text.toString().isNotEmpty() && nSemestre.text.toString().isNotEmpty() && nTelefono.text.toString().isNotEmpty() && email.text.toString().isNotEmpty() && fecha_nac.text.toString().isNotEmpty() && spinner.selectedItemPosition != 0){
                val respuesta = arrayOf(
                    nombre.text.toString(),
                    nControl.text.toString(),
                    fecha_nac.text.toString(),
                    spinner.selectedItem.toString(),
                    nSemestre.text.toString(),
                    curp.text.toString(),
                    rfc.text.toString(),
                    nTelefono.text.toString(),
                    email.text.toString(),
                    direccion.text.toString()
                )
                intent.putExtra("respuesta", respuesta)
                clean()
                startActivity(intent)

            }
            else {
                if (nombre.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingresa tu nombre", Toast.LENGTH_SHORT).show()
                    nombre.requestFocus()
                }
                else if (nControl.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingresa tu numero de control", Toast.LENGTH_SHORT).show()
                    nControl.requestFocus()
                }
                else if (fecha_nac.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingresa tu fecha de nacimiento", Toast.LENGTH_SHORT).show()
                    fecha_nac.requestFocus()
                }
                else if (spinner.selectedItemPosition == 0) {
                    Toast.makeText(this, "Ingresa tu carrera", Toast.LENGTH_SHORT).show()
                }
                else if (nSemestre.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingresa tu numero de semestre", Toast.LENGTH_SHORT).show()
                    nSemestre.requestFocus()
                }
                else if (curp.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingresa tu CURP", Toast.LENGTH_SHORT).show()
                    curp.requestFocus()
                }
                else if (rfc.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingresa tu RFC", Toast.LENGTH_SHORT).show()
                    rfc.requestFocus()
                }
                else if (nTelefono.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingresa tu numero de telefono", Toast.LENGTH_SHORT).show()
                    nTelefono.requestFocus()
                }
                else if (email.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingresa tu email", Toast.LENGTH_SHORT).show()
                    email.requestFocus()
                }
                else if (direccion.text.toString().isEmpty()) {
                    Toast.makeText(this, "Ingresa tu direccion", Toast.LENGTH_SHORT).show()
                    direccion.requestFocus()
                }
            }

        }

    }

    fun clean(){
        val nombre = findViewById<EditText>(R.id.Nombre)
        val curp = findViewById<EditText>(R.id.CURP)
        val rfc = findViewById<EditText>(R.id.RFC)
        val direccion = findViewById<EditText>(R.id.Direccion)
        val nControl = findViewById<EditText>(R.id.N_Control)
        val nSemestre = findViewById<EditText>(R.id.N_Semestre)
        val nTelefono = findViewById<EditText>(R.id.N_Telefono)
        val email = findViewById<EditText>(R.id.Email)
        val fecha_nac = findViewById<EditText>(R.id.Fecha_Nac)
        spinner = findViewById(R.id.spinnerCarrera)

        nombre.text.clear()
        curp.text.clear()
        rfc.text.clear()
        direccion.text.clear()
        nControl.text.clear()
        nSemestre.text.clear()
        nTelefono.text.clear()
        email.text.clear()
        fecha_nac.text.clear()
        spinner.setSelection(0)
    }


}

