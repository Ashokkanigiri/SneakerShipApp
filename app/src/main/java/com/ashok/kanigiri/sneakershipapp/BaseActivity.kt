package com.ashok.kanigiri.sneakershipapp

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ashok.kanigiri.sneakershipapp.databinding.BottomLayoutBinding
import com.ashok.kanigiri.sneakershipapp.databinding.HeaderLayoutBinding

open class BaseActivity: AppCompatActivity() {

    private var headerBinding: HeaderLayoutBinding? = null
    private var bottomBar: BottomLayoutBinding? = null

    fun setHeaderBar(binding: HeaderLayoutBinding){
        this.headerBinding = binding
    }

    fun setBottomBar(binding: HeaderLayoutBinding){
        this.headerBinding = binding
    }

    fun setHeaderTitle(text: String){
        headerBinding?.tvHeaderTitle?.text = text
    }

    fun showHeaderTitleVisibility(shouldShowHeaderBar: Boolean){
        if(shouldShowHeaderBar){
            headerBinding?.tvHeaderTitle?.visibility = View.VISIBLE
        }else{
            headerBinding?.tvHeaderTitle?.visibility = View.GONE
        }
    }

    fun showLeftArrowVisibility(shouldLeftArrow: Boolean){
        if(shouldLeftArrow){
            headerBinding?.ivLeft?.visibility = View.VISIBLE
        }else{
            headerBinding?.ivLeft?.visibility = View.GONE
        }
    }

    fun searchIconVisibility(shouldShowSearchIcon: Boolean){
        if(shouldShowSearchIcon){
            headerBinding?.ivSearch?.visibility = View.VISIBLE
        }else{
            headerBinding?.ivSearch?.visibility = View.GONE
        }
    }

    fun handleLeftArrowClickListener(listener: View.OnClickListener){
        headerBinding?.ivLeft?.setOnClickListener(listener)
    }

    fun handleSearchIconClick(listener: View.OnClickListener){
        headerBinding?.ivSearch?.setOnClickListener(listener)
    }

    fun handleHomeButtonClicked(listener: View.OnClickListener){
        bottomBar?.ivHome?.setOnClickListener(listener)
    }

    fun handleCartButtonClicked(listener: View.OnClickListener){
        bottomBar?.ivCart?.setOnClickListener(listener)
    }

}