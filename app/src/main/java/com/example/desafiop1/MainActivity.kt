package com.example.desafiop1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val usuarioCorreto = "admin"
    private val senhaCorreta = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editUsuario = findViewById<EditText>(R.id.edt_usuario)
        val editSenha = findViewById<EditText>(R.id.edt_senha)
        val btnEntrar = findViewById<Button>(R.id.btn_entrar)

        btnEntrar.setOnClickListener {
            val usuario = editUsuario.text.toString()
            val senha = editSenha.text.toString()

            if(usuario == usuarioCorreto && senha == senhaCorreta){
                startActivity(Intent(this, MainCadFilmeActivity::class.java))
                finish()
            } else{
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
         }
    }
}