package com.ashok.kanigiri.sneakershipapp.feature.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ashok.kanigiri.sneakershipapp.MainActivity
import com.ashok.kanigiri.sneakershipapp.R
import com.ashok.kanigiri.sneakershipapp.databinding.FragmentHomeBinding
import com.ashok.kanigiri.sneakershipapp.feature.home.HomeViewModelEvent
import com.ashok.kanigiri.sneakershipapp.feature.home.viewmodel.HomeViewModel
import com.ashok.kanigiri.sneakershipapp.services.room.RoomDataSource
import com.example.mynewsapp.service.di.Injectable
import com.example.mynewsapp.service.di.modules.viewmodelmodule.ViewModelFactory
import javax.inject.Inject

class HomeFragment: Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var roomDataSource: RoomDataSource
    lateinit var viewModel: HomeViewModel
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        initFragment()
        loadData()
        observeViewModel()
        setUpHeaderBar()
    }

    private fun observeViewModel() {
        viewModel.event.observe(viewLifecycleOwner, Observer { event->
            when(event){
                is HomeViewModelEvent.NavigateToSneakerDetail->{
                    navigateToSneakerDetail(event.sneakerId)
                }
                is HomeViewModelEvent.GetAllSneakers ->{
                    viewModel.loadAdapter(event.sneakerList)
                }
            }
        })
    }

    private fun navigateToSneakerDetail(sneakerId: String){
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToSneakerDetailFragment(sneakerId)
        )
    }

    private fun loadData() {
        viewModel.loadData()
    }

    private fun initFragment() {
        binding.rvHomeData.layoutManager = GridLayoutManager(requireContext(), viewModel.HOME_DATA_GRID_SPAN_COUNT)
    }

    private fun setUpHeaderBar() {
        (activity as MainActivity).setHeaderBar(binding.headerBar)
        (activity as MainActivity).showHeaderTitleVisibility(true)
        (activity as MainActivity).showLeftArrowVisibility(false)
        (activity as MainActivity).searchIconVisibility(true)
        (activity as MainActivity).setHeaderTitle("Sneaker Ship")
        (activity as MainActivity).handleSearchIconClick(object : View.OnClickListener{
            override fun onClick(v: View?) {

            }

        })

    }
}