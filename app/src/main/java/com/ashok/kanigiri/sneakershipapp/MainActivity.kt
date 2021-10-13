package com.ashok.kanigiri.sneakershipapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Window
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.ashok.kanigiri.sneakershipapp.databinding.ActivityMainBinding
import com.ashok.kanigiri.sneakershipapp.databinding.LayoutApiKeyErrorDialogBinding
import com.ashok.kanigiri.sneakershipapp.services.rest.RestApiSource
import com.ashok.kanigiri.sneakershipapp.utils.ConstantUtils
import com.ashok.kanigiri.sneakershipapp.utils.setupWithNavController
import com.example.mynewsapp.service.di.modules.viewmodelmodule.ViewModelFactory
import com.google.gson.Gson
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : BaseActivity(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    lateinit var viewModel: MainActivityViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
        binding.lifecycleOwner = this
        setUpBottomNav()
        if(ConstantUtils.API_KEY_KEY.trim().equals("")){
            populateConnectivityDialog()
        }
    }

    private fun populateConnectivityDialog(){
        val inflator = LayoutInflater.from(this)
        val connectivityBinding = LayoutApiKeyErrorDialogBinding.inflate(inflator)
        val dialog = Dialog(this)
        dialog.setContentView(connectivityBinding.root)
        dialog.setCancelable(false)
        connectivityBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
            finish()
        }
        dialog.show()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    private fun setUpBottomNav() {
        val navGraphIDS = listOf(
            R.navigation.nav_graph_home,
            R.navigation.nav_graph_add_to_cart,
        )
        binding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIDS,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )
    }
}