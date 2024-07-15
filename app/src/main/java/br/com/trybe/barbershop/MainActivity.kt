package br.com.trybe.barbershop

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.DisplayPhoto
import android.view.View
import br.com.trybe.barbershop.databinding.ActivityMainBinding
import br.com.trybe.barbershop.view.Home
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btLogin.setOnClickListener {

            val name = binding.editNome.text.toString()
            val phone = binding.editPhone.text.toString()

            when{
                name.isEmpty() -> {
                    mensagem(it, "Coloque o seu nome!")
                } phone.isEmpty() -> {
                    mensagem(it, "Preencha o telefone!")
                } else -> {
                    navegarPraHome(name, phone)
                }
            }
        }
    }

    private fun mensagem(view: View, mensagem: String){
        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }

    private fun navegarPraHome(name: String, phone: String) {
        val intent = Intent(this, Home::class.java)
        intent.putExtra("nome", name)
        intent.putExtra("telefone", phone)
        startActivity(intent)
    }
}