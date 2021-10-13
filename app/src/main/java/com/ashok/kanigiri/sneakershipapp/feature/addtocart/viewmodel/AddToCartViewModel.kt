package com.ashok.kanigiri.sneakershipapp.feature.addtocart.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ashok.kanigiri.sneakershipapp.SneakerShipApplication
import com.ashok.kanigiri.sneakershipapp.feature.addtocart.view.AddToCartAdapter
import com.ashok.kanigiri.sneakershipapp.services.room.RoomDataSource
import com.ashok.kanigiri.sneakershipapp.services.room.models.Sneaker
import java.util.stream.IntStream
import javax.inject.Inject

class AddToCartViewModel @Inject constructor(private val roomDataSource: RoomDataSource, private val application: SneakerShipApplication): ViewModel() {

    val adapter = AddToCartAdapter(this)
    val subtotal = MutableLiveData<String>()
    val taxes = MutableLiveData<String>()
    val total = MutableLiveData<String>()

    fun setAdapter(): AddToCartAdapter{
        return adapter
    }

    fun loadAdapter(sneakersList: List<Sneaker>){
        adapter.submitList(sneakersList)
        calculateSubtotal(sneakersList)
    }

    fun calculateSubtotal(sneakersList: List<Sneaker>){
        var totalPrice=0
        sneakersList.map { totalPrice = totalPrice+ (it.retailPrice?:0) }
        subtotal.postValue(totalPrice.toString())
        val tax = totalPrice*10/100
        taxes.postValue(tax.toString())
        total.postValue((totalPrice+tax).toString())
    }

    fun removeSneakerFromCart(sneakerId: String){
        roomDataSource.getSneakerDao().removeSneakerFromCart(sneakerId)
        Toast.makeText(application, "Item removed from cart", Toast.LENGTH_SHORT).show()
    }
}