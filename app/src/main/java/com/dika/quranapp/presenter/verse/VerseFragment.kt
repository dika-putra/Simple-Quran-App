package com.dika.quranapp.presenter.verse

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import com.dika.quranapp.databinding.FragmentVerseBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class VerseFragment : Fragment() {
    private var _binding: FragmentVerseBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<VerseViewModel>()
    private val verseAdapter by lazy { VerseAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVerseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @ExperimentalPagingApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragment = this
        binding.adapter = verseAdapter

        lifecycleScope.launchWhenStarted {
            viewModel.versesResult.collectLatest {
                verseAdapter.submitData(it)
            }
        }
    }

    fun onRefresh() {
        verseAdapter.refresh()
    }
}