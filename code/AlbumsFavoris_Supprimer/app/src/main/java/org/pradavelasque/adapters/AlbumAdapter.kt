package org.pradavelasque.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.pradavelasque.databinding.AlbumItemBinding
import org.pradavelasque.models.Album
import org.pradavelasque.ActivityDetails

class AlbumAdapter(private val onRemoveAlbum: (Album) -> Unit) : ListAdapter<Album, AlbumAdapter.AlbumItemViewHolder>(AlbumItemDiffCallback) {
    // binding nous permet d'accéder à tout le champs de notre layout album_item.xml
    inner class AlbumItemViewHolder(private val binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album) {
            //binding.tvId.text = album.id.toString() // Attention! Il faut toujours s'assurer qu'on assigne une String.
            binding.tvSelectedArtistName.text = album.artistName
            binding.tvSelectedName.text = album.name

            // Action à réaliser lors du clic sur le nom de l'album
            binding.albumItem.setOnClickListener {
                // Action à réaliser lors du clic, par exemple afficher un message ou démarrer une nouvelle activité
                val intent = Intent(binding.root.context, ActivityDetails::class.java)
                intent.putExtras(bundleOf("selectedItem" to album))
                binding.root.context.startActivity(intent)
            }

            binding.btnSupprimer.setOnClickListener {
                onRemoveAlbum(album)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumItemViewHolder {
        val binding: AlbumItemBinding = AlbumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object AlbumItemDiffCallback : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id &&
                oldItem.artistName == newItem.artistName &&
                oldItem.name == newItem.name
    }
}