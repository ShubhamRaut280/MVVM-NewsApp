package com.shubham.newsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.shubham.newsapp.Db.ArticleDatabase
import com.shubham.newsapp.R
import com.shubham.newsapp.Repository.NewsRepository
import com.shubham.newsapp.ViewModels.NewsViewModel
import com.shubham.newsapp.ViewModels.NewsViewModelProviderFactory
import com.shubham.newsapp.databinding.ActivityHomeBinding
import com.shubham.newsapp.ui.fragments.BreakingNews
import com.shubham.newsapp.ui.fragments.SavedNews
import com.shubham.newsapp.ui.fragments.SearchNews

class HomeActivity : AppCompatActivity() {
     lateinit var binding : ActivityHomeBinding

     lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val newsRepository  =  NewsRepository(ArticleDatabase(this))

        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)

        val viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)




        init()








    }

    fun init() {
        loadFragment(BreakingNews())

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.breakingNewsFragment -> {
                    loadFragment(BreakingNews())
                    true
                }

                R.id.savedNewsFragment -> {
                    loadFragment(SavedNews())
                    true
                }

                R.id.searchNewsFragment -> {
                    loadFragment(SearchNews())
                    true
                }

                else -> false
            }
        }

    }

    fun loadFragment( fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.flFragment, fragment).commit()
    }
}
