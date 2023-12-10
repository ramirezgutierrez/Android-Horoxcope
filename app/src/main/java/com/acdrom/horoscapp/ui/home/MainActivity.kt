package com.acdrom.horoscapp.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.acdrom.horoscapp.R
import com.acdrom.horoscapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
    }
    private fun initUi() {
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHost.navController
        binding.bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.horoscopeFragment -> {
                    binding.bottomNavigationView.menu.findItem(R.id.horoscopeFragment).isChecked = true
                }
                R.id.luckFragment -> {
                    binding.bottomNavigationView.menu.findItem(R.id.luckFragment).isChecked = true
                }
                R.id.palmistryFragment -> {
                    binding.bottomNavigationView.menu.findItem(R.id.palmistryFragment).isChecked = true
                }
            }
        }
    }
}