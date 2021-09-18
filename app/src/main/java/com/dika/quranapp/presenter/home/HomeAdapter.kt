package com.dika.quranapp.presenter.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dika.quranapp.databinding.ItemChapterBinding
import com.dika.quranapp.domain.model.Chapter

class HomeAdapter(private val listener: HomeAdapterListener) :
    ListAdapter<Chapter, HomeAdapter.ChapterViewHolder>(Companion) {

    interface HomeAdapterListener {
        fun onVerseClick(model: Chapter)
        fun onDetailClick(model: Chapter)
    }

    class ChapterViewHolder(
        private val binding: ItemChapterBinding,
        private val listener: HomeAdapterListener
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.listener = listener
        }

        fun onBind(item: Chapter) {
            binding.model = item
        }
    }

    companion object : DiffUtil.ItemCallback<Chapter>() {
        override fun areItemsTheSame(oldItem: Chapter, newItem: Chapter): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Chapter, newItem: Chapter): Boolean =
            oldItem.id == newItem.id && oldItem.nameSimple == newItem.nameSimple
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ChapterViewHolder(
            ItemChapterBinding.inflate(layoutInflater, parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: ChapterViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }
}