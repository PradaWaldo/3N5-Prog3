package org.pradavelasque

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import org.pradavelasque.adapters.AlbumAdapter
import org.pradavelasque.adapters.MonAdapter
import org.pradavelasque.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
private lateinit var adapter: AlbumAdapter // L'adapteur est accessible partout dans notre classe

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        fillRecycler()
    }

//    private fun setupRecycler() {
//        adapter = MonAdapter() // Créer l'adapteur
//        binding.rvMonAdapter.adapter = adapter // Assigner l'adapteur au RecyclerView
//        binding.rvMonAdapter.setHasFixedSize(true) // Option pour améliorer les performances
//        binding.rvMonAdapter.addItemDecoration( // Ajouter un séparateur entre chaque élément
//            DividerItemDecoration(
//                binding.rvMonAdapter.context, DividerItemDecoration.VERTICAL
//            )
//        )
//    }
private fun setupRecycler() {
    adapter = AlbumAdapter() // Créer l'adapteur
    binding.rvAlbumAdapterAdapter.adapter = adapter // Assigner l'adapteur au RecyclerView
    binding.rvAlbumAdapterAdapter.setHasFixedSize(true) // Option pour améliorer les performances
    binding.rvAlbumAdapterAdapter.addItemDecoration( // Ajouter un séparateur entre chaque élément
        DividerItemDecoration(
            binding.rvPersonneAdapter.context, DividerItemDecoration.VERTICAL
        )
    )
}

    private fun fillRecycler() {
        val items: MutableList<String> = mutableListOf()
        for (i in 1..10000) {
            items.add("Item #$i")
        }
        val newitems: MutableList<String> = mutableListOf("What's Going On", "Pet Sounds", "Blue", "Songs in the Key of Life", "Abbey Road", "Nevermind")
        adapter.submitList(newitems) // Pour changer le contenu de la liste, utiliser submitList de l'adapteur
    }

}