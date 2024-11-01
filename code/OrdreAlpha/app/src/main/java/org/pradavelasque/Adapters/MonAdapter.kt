package org.pradavelasque.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.pradavelasque.databinding.MonItemBinding

class MonAdapter(private val context: Context) : ListAdapter<String, MonAdapter.MonItemViewHolder>(MonItemDiffCallback) {

    // binding nous permet d'accéder à tout le champs de notre layout mon_item.xml
    inner class MonItemViewHolder(private val binding: MonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.tvPrenom.text = item // On affiche l'élément dans le TextView

            binding.btnMonter.setOnClickListener {
                val position = adapterPosition
                if (position > 0) {  // On vérifie qu'il y a un élément au-dessus
                    val updatedList : MutableList<String> = currentList.toMutableList().apply {
                        val item = removeAt(position)
                        add(position - 1, item)

                    }
                    submitList(updatedList)
                }
                checkForWin()
            }

            binding.btnDescendre.setOnClickListener {
                val position = adapterPosition
                if (position < currentList.size - 1) {  // On vérifie qu'il y a un élément en dessous
                    val updatedList = currentList.toMutableList().apply {
                        val item = removeAt(position)
                        add(position + 1, item)
                    }
                    submitList(updatedList)
                    checkForWin()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonItemViewHolder {
        val binding: MonItemBinding = MonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MonItemViewHolder, position: Int) {
        val item: String = getItem(position)
        holder.bind(item)
    }
    // Méthode pour vérifier si la liste est triée alphabétiquement
    private fun checkForWin() {
        if (currentList == currentList.sorted()) {
            showWinDialog()
            resetList()
        }
    }

    // Afficher le dialogue de félicitations
    private fun showWinDialog() {
        AlertDialog.Builder(context)
            .setTitle("Bravo !")
            .setMessage("Vous avez trié la liste avec succès.")
            .setPositiveButton("OK", null)
            .show()
    }

    // Mélanger et réinitialiser la liste
    private fun resetList() {
        val shuffledList = currentList.toMutableList().apply { shuffle() }
        submitList(shuffledList)
    }
}

object MonItemDiffCallback : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }
}