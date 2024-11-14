package org.pradavelasque.activity

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.google.android.material.snackbar.Snackbar
import org.pradavelasque.R
import org.pradavelasque.adapter.MonAdapter
import org.pradavelasque.databinding.ActivityMainBinding
import org.pradavelasque.databinding.NavHeaderBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MonAdapter // L'adapteur est accessible partout dans notre classe
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Sujets"

        setupRecycler()
        fillRecycler()
        setupDrawer()

    }
    private fun setupDrawer() {
        setupDrawerApplicationBar()
        setupDrawerItemSelected()
        setupDrawerHeader()
    }

    private fun setupDrawerApplicationBar() {
        // Afficher le menu hamburger sur la barre d'application
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        // Lier le tiroir de navigation à l'activité
        // R.string.ouvert et R.string.ferme sont des strings de ressource.
        // Référez-vous à la recette pour les strings de ressource pour voir comment les ajouter :
        // https://info.cegepmontpetit.ca/3N5-Prog3/recettes/ressources-string
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.dlTiroir, R.string.ouvert, R.string.ferme)

        // Faire en sorte que le menu hamburger se transforme en flèche au clic, et vis versa
        binding.dlTiroir.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    private fun setupDrawerItemSelected() {
        // Réagir aux clics sur les actions de menu
        binding.nvTiroir.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.accueil_item -> {
                    Snackbar.make(binding.root, "On va à l'accueil!", Snackbar.LENGTH_SHORT).show()
                    finish()
                }
                R.id.ajouter_item -> {
                    Snackbar.make(
                        binding.root, "On va ajouter quelque chose!", Snackbar.LENGTH_SHORT
                    ).show()
                }
                R.id.deconnexion_item -> {
                    Snackbar.make(
                        binding.root, "Déconnexion de votre tiroir", Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
            false
        }
    }

    private fun setupDrawerHeader() {
        // Si on veut avoir du contenu dynamique dans l'en-tête,
        val headerBinding: NavHeaderBinding = NavHeaderBinding.bind(binding.nvTiroir.getHeaderView(0))
        headerBinding.headerNameResult.text = "Prada";
    }

    // Se déclenche lorsqu'un élément de la barre d'application est sélectionné
    // Exemple : lorsqu'on clique sur le menu hamburger
    // Peut aussi se combiner avec les autres options de menu qui se retrouvent dans la barre d'application
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Réagir au clic sur le menu hamburger
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item)
    }

    // Les deux méthodes suivantes permettent de synchroniser le menu hamburger
    // après avoir effectué une rotation de l'écran
    // Pour mieux comprendre :
    // 1. Commentez ces deux méthodes
    // 2. Relancer l'application
    // 3. Ouvrez le menu hamburger
    // 4. Tournez le péripérique pour qu'il soit en mode paysage
    // 5. Notez ce qui est arrivé au menu hambuger
    // 6. Recommencez, mais en décommentant les deux méthodes
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        actionBarDrawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        actionBarDrawerToggle.onConfigurationChanged(newConfig)
        super.onConfigurationChanged(newConfig)
    }


    private fun setupRecycler() {
        adapter = MonAdapter() // Créer l'adapteur
        binding.rvMonAdapter.adapter = adapter // Assigner l'adapteur au RecyclerView
        binding.rvMonAdapter.setHasFixedSize(true) // Option pour améliorer les performances
        binding.rvMonAdapter.addItemDecoration( // Ajouter un séparateur entre chaque élément
            DividerItemDecoration(
                binding.rvMonAdapter.context, DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun fillRecycler() {
        val items: MutableList<String> = mutableListOf()
        for (i in 1..10000) {
            items.add("Item #$i")
        }
        val sujetsDeJeux = mutableListOf(
            "L’évolution des mondes ouverts",
            "L'impact de l’intelligence artificielle (IA) dans les jeux vidéo",
            "Les mécaniques de gameplay et l’expérience de jeu",
            "Les jeux vidéo et la narration interactive",
            "Les microtransactions et leur impact sur l’industrie",
            "Les jeux vidéo comme moyen d’éducation",
            "La réalité virtuelle et augmentée dans les jeux vidéo",
            "Les jeux vidéo indépendants et leur influence sur l'industrie",
            "L’évolution des graphismes et du design artistique",
            "Le rôle des joueurs dans la création de contenu"
        )
        adapter.submitList(sujetsDeJeux) // Pour changer le contenu de la liste, utiliser submitList de l'adapteur
    }

}