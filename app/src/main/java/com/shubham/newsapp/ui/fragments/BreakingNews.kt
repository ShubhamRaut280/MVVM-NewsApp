package com.shubham.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.shubham.newsapp.R
import com.shubham.newsapp.ViewModels.NewsViewModel
import com.shubham.newsapp.ui.HomeActivity

class BreakingNews : Fragment(R.layout.fragment_breaking_news) {
    lateinit var viewModel: NewsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as HomeActivity).viewModel
    }
}