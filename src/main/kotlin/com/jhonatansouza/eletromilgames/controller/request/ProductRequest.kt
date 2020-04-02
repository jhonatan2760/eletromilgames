package com.jhonatansouza.eletromilgames.controller.request

import com.jhonatansouza.eletromilgames.repository.ProductItem

data class ProductRequest (val name:String, val simpleDescription:String, val quantity:Int,
    val brand_new:Boolean, val price:Double){


    fun toItem():ProductItem{
        return ProductItem(this.name, this.simpleDescription, this.quantity, this.brand_new, this.price);
    }
}