package com.dika.quranapp.presenter.verse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dika.quranapp.databinding.ItemVerseBinding
import com.dika.quranapp.domain.model.Verse

class VerseAdapter : PagingDataAdapter<Verse, VerseAdapter.VerseViewHolder>(Companion) {

    class VerseViewHolder(
        private val binding: ItemVerseBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: Verse) {
            binding.value = item.words.joinToString { it.translation.text }
        }
    }

    companion object : DiffUtil.ItemCallback<Verse>() {
        override fun areItemsTheSame(oldItem: Verse, newItem: Verse): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Verse, newItem: Verse): Boolean =
            oldItem.id == newItem.id && oldItem.verseKey == newItem.verseKey
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return VerseViewHolder(ItemVerseBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: VerseViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.onBind(it) }
    }
}