package org.pradavelasque.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.pradavelasque.databinding.MonProfilBinding

class ProfilActivity : AppCompatActivity() {
    private lateinit var binding: MonProfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MonProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Prada"

    }
}