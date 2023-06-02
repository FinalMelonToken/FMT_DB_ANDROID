package com.example.finalmelontokenandroid.features.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.finalmelontokenandroid.R
import com.example.finalmelontokenandroid.base.BaseActivity
import com.example.finalmelontokenandroid.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModels()
    override fun observerViewModel() {
        bindingViewEvent { event ->
            when (event) {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_main) as NavHostFragment
//        val navController = navHostFragment.findNavController()
//        mBinding.bottomNav.setupWithNavController(navController)
    }
}