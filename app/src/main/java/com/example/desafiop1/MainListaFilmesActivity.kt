package com.example.desafiop1
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainListaFilmesActivity : AppCompatActivity() {
    private lateinit var adapter: FilmeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_lista_filmes)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_filmes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = FilmeAdapter(FilmeRepository.listaFilmes) { filme ->
            FilmeRepository.remover(filme)
            adapter.notifyDataSetChanged()
        }
        recyclerView.adapter = adapter

        val btnVoltar = findViewById<Button>(R.id.btn_voltar)
        btnVoltar.setOnClickListener {
            startActivity(Intent(this, MainCadFilmeActivity::class.java))
            finish()
        }
    }
}