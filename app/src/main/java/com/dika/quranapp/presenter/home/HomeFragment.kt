package com.dika.quranapp.presenter.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.databinding.FragmentHomeBinding
import com.dika.quranapp.domain.model.Chapter
import com.dika.quranapp.presenter.common.observe
import com.dika.quranapp.presenter.common.showSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeAdapter.HomeAdapterListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel>()
    private val homeAdapter by lazy { HomeAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.adapter = homeAdapter
        observe(viewModel.chaptersLiveData, ::observeChapters)
    }

    private fun observeChapters(result: Result<List<Chapter>>) {
        when (result.status) {
            Result.Status.SUCCESS -> {
                binding.showLoading = false
                homeAdapter.submitList(result.data)
            }
            Result.Status.ERROR -> {
                binding.showLoading = false
                showSnackBar(result.message)
            }
            Result.Status.LOADING -> binding.showLoading = true
        }
    }

    override fun onVerseClick(model: Chapter) {
        val direction =
            HomeFragmentDirections.actionHomeFragmentToVerseFragment(model.nameSimple, model.id)
        findNavController().navigate(direction)
    }

    override fun onDetailClick(model: Chapter) {
    }
}