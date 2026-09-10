package com.example.desafiop1

object FilmeRepository {
    val listaFilmes = mutableListOf<Filme>()
    fun adicionar(filme: Filme) {
        listaFilmes.add(filme)
    }

    fun remover(filme: Filme) {
        listaFilmes.remove((filme))
    }
}

