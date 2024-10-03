package org.pradavelasque

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.pradavelasque.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var listeButtons : List<Button>

    var scoreTops = 0
    var scoreFlops = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvTops.setOnClickListener(View.OnClickListener {
            println("Coucou")
            binding.tvTops.setText("Lapin")
        })
        listeButtons = listOf(
            binding.btn1,
            binding.btn2,
            binding.btn3,
            binding.btn4,
            binding.btn5,
            binding.btn6,
            binding.btn7,
            binding.btn8,
            binding.btn9
        )

        for (btn in listeButtons){
            btn.setOnClickListener(View.OnClickListener {
                reeagirAuClic(it)
            })
        }

        initialiser()
    }

    fun initialiser(){
        //choisir ube case pour le lapin au hasard
        for (btn in listeButtons){
            btn.setText("Taupe")
        }
        //choisir un boutton au hasard dans la liste
        val boutonLapin = listeButtons.random()
        boutonLapin.setText("Lapin")
        //mettre tous les autres a taupe

    }

    fun reeagirAuClic(it: View){
        // detecter si le boutton appuye est le lapin
        val boutonClique = it as Button
        if (boutonClique.text == "Lapin") {
            boutonClique.setText("Lapin")
            initialiser()
            scoreTops++
        }
        else{
            scoreFlops++
        }
        // mettre ajour l'affichage des scores
        binding.tvTops.setText("Tops: $scoreTops")
        binding.tvFlops.setText("Flops: $scoreFlops")

    }
}