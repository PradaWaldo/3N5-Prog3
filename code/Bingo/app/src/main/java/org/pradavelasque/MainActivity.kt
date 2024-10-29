package org.pradavelasque

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import org.pradavelasque.adapters.TirageAdapter
import org.pradavelasque.databinding.ActivityMainBinding
import org.pradavelasque.models.Tirage
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TirageAdapter // L'adapteur est accessible partout dans notre classe

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
        fillRecycler()
    }

    private fun setupRecycler() {
        adapter = TirageAdapter() // Créer l'adapteur
        binding.rvTirageAdapter.adapter = adapter // Assigner l'adapteur au RecyclerView
        binding.rvTirageAdapter.setHasFixedSize(true) // Option pour améliorer les performances
        binding.rvTirageAdapter.addItemDecoration( // Ajouter un séparateur entre chaque élément
            DividerItemDecoration(
                binding.rvTirageAdapter.context, DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun fillRecycler() {
        val items: MutableList<Tirage> = mutableListOf()
        val numbers: MutableList<Int> = (1..75).toMutableList() //liste de numéros de 1 à 75
        numbers.shuffle() // Mélanger les numéros
        var lettre : String = ""

        for (i in 1..75) {
            val randomNumber = numbers.removeAt(0) // Get a unique number from the list

            lettre = when (randomNumber) {
                in 1..15 -> "B"
                in 16..30 -> "I"
                in 31..45 -> "N"
                in 46..60 -> "G"
                in 61..75 -> "O"
                else -> ""
            }
            items.add(Tirage("Tirage #$i", "Numéro tiré : $randomNumber", lettre))
        }

        adapter.submitList(items) // Pour changer le contenu de la liste, utiliser submitList de l'adapteur
    }
}