package ir.aminrahkan.instagramsample.presentation.ui

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import ir.aminrahkan.instagramsample.R
import ir.aminrahkan.instagramsample.databinding.ActivityMainBinding
import ir.aminrahkan.instagramsample.presentation.base.BaseActivity
import kotlin.concurrent.thread


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/11/22 - 2022
// Project name : Instagram Sample


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHost: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation()

/*
        thread {
            Thread.sleep(7000)
            runOnUiThread {
            navHost.navController.navigate(R.id.action_wallFragment_to_detailFragment)
            }
        }*/
    }

    private fun initNavigation() {
        navHost =
            supportFragmentManager.findFragmentById(R.id.fcv_main_container) as NavHostFragment
        navHost.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.wallFragment -> {}
                R.id.detailFragment -> {}
            }
        }
        navHost.navController.setGraph(R.navigation.nav_graph)
    }
}