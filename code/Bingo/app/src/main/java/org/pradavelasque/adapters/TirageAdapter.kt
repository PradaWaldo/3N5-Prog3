package org.pradavelasque.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.pradavelasque.databinding.MonItemBinding
import org.pradavelasque.models.Tirage

class TirageAdapter : ListAdapter<Tirage, TirageAdapter.MonItemViewHolder>(TirageItemDiffCallback) {

    // binding nous permet d'accéder à tout le champs de notre layout mon_item.xml
    inner class MonItemViewHolder(private val binding: MonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tirage: Tirage) {
            binding.tvNumeroTirage.text = tirage.NumeroTirage.toString() // On affiche l'élément dans le TextView
            binding.tvNumeroTirer.text = tirage.NumeroTirer.toString() // On affiche l'élément dans le TextView
            binding.tvLettreTirer.text = tirage.LettreTirer // On affiche l'élément dans le TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonItemViewHolder {
        val binding: MonItemBinding = MonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MonItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

object TirageItemDiffCallback : DiffUtil.ItemCallback<Tirage>() {
    override fun areItemsTheSame(oldItem: Tirage, newItem: Tirage): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Tirage, newItem: Tirage): Boolean {
        return oldItem.NumeroTirage == newItem.NumeroTirage
                && oldItem.NumeroTirer == newItem.NumeroTirer
                && oldItem.LettreTirer == newItem.LettreTirer
    }
}