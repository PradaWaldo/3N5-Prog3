package org.pradavelasque

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.pradavelasque.databinding.ActivityDetailsBinding
import org.pradavelasque.models.Album

private lateinit var binding: ActivityDetailsBinding

class ActivityDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val album = intent.getParcelableExtra<Album>("selectedItem")
        binding.tvArtistName.text = album?.artistName
        binding.tvName.text = album?.name


    }
}