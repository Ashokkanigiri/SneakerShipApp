package com.ashok.kanigiri.sneakershipapp.feature.sneakerdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ashok.kanigiri.sneakershipapp.MainActivity
import com.ashok.kanigiri.sneakershipapp.R
import com.ashok.kanigiri.sneakershipapp.databinding.FragmentSneakerDetailBinding
import com.ashok.kanigiri.sneakershipapp.feature.sneakerdetail.viewmodel.SneakerDetailViewModel
import com.example.mynewsapp.service.di.Injectable
import com.example.mynewsapp.service.di.modules.viewmodelmodule.ViewModelFactory
import javax.inject.Inject

class SneakerDetailFragment: Fragment(), Injectable {

    @Inject
    lateinit var factory: ViewModelFactory

    lateinit var binding: FragmentSneakerDetailBinding

    lateinit var viewmodel: SneakerDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sneaker_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        viewmodel = ViewModelProvider(this, factory).get(SneakerDetailViewModel::class.java)
        binding.viewmodel = viewmodel
        viewmodel.sneakerId = arguments?.getString("sneakerId")

        loadData()
        setUpHeaderBar()
        observeViewModel()

    }

    private fun setUpHeaderBar() {
        (activity as MainActivity).setHeaderBar(binding.headerLayout)
        (activity as MainActivity).showHeaderTitleVisibility(true)
        (activity as MainActivity).showLeftArrowVisibility(true)
        (activity as MainActivity).searchIconVisibility(false)
        (activity as MainActivity).setHeaderTitle("Sneaker Detail")
        (activity as MainActivity).handleLeftArrowClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                findNavController().popBackStack()
            }
        })

    }

    private fun loadData() {
        viewmodel.sneakerId?.let {  viewmodel.getSneaker(it) }
    }

    private fun observeViewModel() {
        viewmodel.event.observe(viewLifecycleOwner, Observer { event->
            when(event){
                is SneakerDetailViewModelEvent.GetSneaker->{
                    binding.sneaker = event.sneaker
                }
            }
        })
    }
}