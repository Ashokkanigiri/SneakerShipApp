package com.ashok.kanigiri.sneakershipapp.feature.addtocart.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ashok.kanigiri.sneakershipapp.MainActivity
import com.ashok.kanigiri.sneakershipapp.R
import com.ashok.kanigiri.sneakershipapp.databinding.FragmentAddToCartBinding
import com.ashok.kanigiri.sneakershipapp.feature.addtocart.viewmodel.AddToCartViewModel
import com.ashok.kanigiri.sneakershipapp.services.room.RoomDataSource
import com.example.mynewsapp.service.di.Injectable
import com.example.mynewsapp.service.di.modules.viewmodelmodule.ViewModelFactory
import javax.inject.Inject

class AddToCartFragment: Fragment(), Injectable {

    @Inject
    lateinit var factory: ViewModelFactory
    @Inject
    lateinit var roomDataSource: RoomDataSource
    lateinit var binding: FragmentAddToCartBinding
    lateinit var viewmodel: AddToCartViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_to_cart, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel = ViewModelProvider(this, factory).get(AddToCartViewModel::class.java)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewmodel

        setUpHeaderBar()
        loadData()
    }

    private fun setUpHeaderBar() {
        (activity as MainActivity).setHeaderBar(binding.headerBar)
        (activity as MainActivity).showHeaderTitleVisibility(true)
        (activity as MainActivity).showLeftArrowVisibility(false)
        (activity as MainActivity).searchIconVisibility(false)
        (activity as MainActivity).setHeaderTitle("Orders")
    }

    private fun loadData() {
        roomDataSource.getSneakerDao().getAllSneakers().observe(viewLifecycleOwner, Observer {
            viewmodel.loadAdapter(it)
        })
    }
}