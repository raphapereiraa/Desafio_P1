package com.example.desafiop1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class FilmeAdapter(
    
    private val filmes: MutableList<Filme>,
    private val onExcluir: (Filme) -> Unit
) : RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {
    
    class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPoster: ImageView = itemView.findViewById(R.id.img_poster)
        val txtTitulo: TextView = itemView.findViewById(R.id.txt_titulo_filme)
        val txtGenero: TextView = itemView.findViewById(R.id.txt_genero_filme)
        val btnExcluir: Button = itemView.findViewById(R.id.btn_excluir)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return FilmeViewHolder(view)
    }
    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        val filme = filmes[position]
        holder.txtTitulo.text = filme.titulo
        holder.txtGenero.text = filme.genero
        Glide.with(holder.itemView.context)
            .load(filme.posterUrl)
            .into(holder.imgPoster)
        holder.btnExcluir.setOnClickListener {
            onExcluir(filme)
        }
    }
    override fun getItemCount(): Int = filmes.size
}