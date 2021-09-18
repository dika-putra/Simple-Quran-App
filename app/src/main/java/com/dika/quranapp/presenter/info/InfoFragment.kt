package com.dika.quranapp.presenter.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dika.quranapp.data.common.Result
import com.dika.quranapp.databinding.FragmentInfoBinding
import com.dika.quranapp.domain.model.ChapterInfo
import com.dika.quranapp.presenter.common.observe
import com.dika.quranapp.presenter.common.showSnackBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment() {
    private var _binding: FragmentInfoBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<InfoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        observe(viewModel.chapterInfoLiveData, ::observeChapterInfo)
    }

    private fun observeChapterInfo(result: Result<ChapterInfo?>) {
        when (result.status) {
            Result.Status.SUCCESS -> {
                binding.showLoading = false
                result.data?.let {
                    binding.model = it
                }
            }
            Result.Status.ERROR -> {
                binding.showLoading = false
                showSnackBar(result.message)
            }
            Result.Status.LOADING -> binding.showLoading = true
        }
    }
}