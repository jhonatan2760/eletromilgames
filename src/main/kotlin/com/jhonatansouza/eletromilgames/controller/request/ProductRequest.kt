package com.jhonatansouza.eletromilgames.controller.request

import com.jhonatansouza.eletromilgames.repository.ProductItem

data class ProductRequest (val name:String, val simpleDescription:String, val quantity:Int,
    val brand_new:Boolean, val price:Double){


    fun toItem():ProductItem{
        return ProductItem(name = this.name, simpleDescription = this.simpleDescription, quantity = this.quantity,
                isBrandNew = this.brand_new,
                price = this.price);
    }
}