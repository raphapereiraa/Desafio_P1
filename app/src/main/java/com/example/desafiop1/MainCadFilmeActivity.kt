package com.example.desafiop1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainCadFilmeActivity : AppCompatActivity()

{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_cad_filme)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTitulo = findViewById<EditText>(R.id.edt_titulo)
        val editGenero = findViewById<EditText>(R.id.edt_genero)
        val editUrl = findViewById<EditText>(R.id.edt_url)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)

        btnSalvar.setOnClickListener {
            val titulo = editTitulo.text.toString()
            val genero = editGenero.text.toString()
            val posterUrl = editUrl.text.toString()
            if (titulo.isBlank() || genero.isBlank() || posterUrl.isBlank()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            } else {
                FilmeRepository.adicionar(Filme(titulo, genero, posterUrl))
                Toast.makeText(this, "Filme salvo!", Toast.LENGTH_SHORT).show()
                editTitulo.text.clear()
                editGenero.text.clear()
                editUrl.text.clear()
            }
        }
        fabAvanca.setOnClickListener {
            startActivity(Intent(this, MainListaFilmesActivity::class.java))
        }

    }
}