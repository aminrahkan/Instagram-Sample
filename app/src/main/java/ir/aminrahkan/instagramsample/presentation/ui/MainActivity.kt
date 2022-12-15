package ir.aminrahkan.instagramsample.presentation.ui

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import ir.aminrahkan.instagramsample.R
import ir.aminrahkan.instagramsample.data.local.db.AppDatabase
import ir.aminrahkan.instagramsample.data.local.db.entities.Post
import ir.aminrahkan.instagramsample.databinding.ActivityMainBinding
import ir.aminrahkan.instagramsample.presentation.base.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


// Developer : Amin Rahkan - Amin.Rahkan7@gmail.com  
// Date : 12/11/22 - 2022
// Project name : Instagram Sample

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHost: NavHostFragment

    @Inject
    lateinit var appDb: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initNavigation()
//        initAppData()
    }

    private fun initAppData() {
        CoroutineScope(Dispatchers.IO).launch {
            (0..100).forEach {
                appDb.postDao().insertPost(
                    Post(
                        0,
                        "",
                        "amin$it",
                        "https://cdn2.thedogapi.com/images/HJf4jl9VX_1280.jpg",
                        true,
                        it + 10,
                        it * 2,
                        ""
                    )
                )
            }
        }

    }

    private fun initNavigation() {
        navHost =
            supportFragmentManager.findFragmentById(R.id.fcv_main_container) as NavHostFragment
        navHost.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.wallFragment -> {
                    hideToolBar()
                }
                R.id.detailFragment -> {
                    showToolBar()
                }
            }
        }
        navHost.navController.setGraph(R.navigation.nav_graph)
    }

    private fun hideToolBar() {
        try {
            supportActionBar!!.hide()
        } catch (e: Exception) {
        }
    }

    private fun showToolBar() {
        try {
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowHomeEnabled(true)
                setDisplayShowTitleEnabled(false)
                show()
            }
        } catch (e: Exception) {
        }
    }

    private fun backPressed() {
        onBackPressedDispatcher.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        backPressed()
        return false
    }
}