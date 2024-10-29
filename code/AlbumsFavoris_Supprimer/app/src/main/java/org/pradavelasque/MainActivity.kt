package org.pradavelasque

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import org.pradavelasque.adapters.AlbumAdapter
import org.pradavelasque.databinding.ActivityMainBinding
import org.pradavelasque.models.Album

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AlbumAdapter // L'adapteur est accessible partout dans notre classe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        fillRecycler()

    }

private fun setupRecycler() {
    adapter = AlbumAdapter({ album -> removeAlbumFromList(album) }) // On passe une lambda à l'adapteur pour pouvoir supprimer un album
    binding.rvAlbumAdapter.adapter = adapter
    binding.rvAlbumAdapter.setHasFixedSize(true)
    binding.rvAlbumAdapter.addItemDecoration(
        DividerItemDecoration(binding.rvAlbumAdapter.context, DividerItemDecoration.VERTICAL))
    }

    private fun fillRecycler() {
        val items: MutableList<Album> = mutableListOf()
        var numero : Int = 0
        for (i in 1..10000) {
            items.add(Album(numero, "Artiste", "nom"))
            numero++
        }
        val newItems : MutableList<Album> = mutableListOf(
            Album(1, "Thriller", "Michael Jackson"),
            Album(2, "Back in Black", "AC/DC"),
            Album(3, "The Dark Side of the Moon", "Pink Floyd"),
            Album(4, "Bat Out of Hell", "Meat Loaf")
            )
        adapter.submitList(newItems) // Pour changer le contenu de la liste, utiliser submitList de l'adapteur
    }
    private fun removeAlbumFromList(album: Album) {
        val items : MutableList<Album> = adapter.currentList.toMutableList()
        items.remove(album)
        adapter.submitList(items)
    }
}