package com.jhonatansouza.eletromilgames.controller.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.jhonatansouza.eletromilgames.repository.ProductItem

class ProductRequest{

    var name = ""
    var simpleDescription = ""
    var quantity = 0
    @JsonProperty("brand_new")
    var isBrandNew = false
    var price = 0.00

    fun toItem():ProductItem{
        return ProductItem(this.name, this.simpleDescription, this.quantity, this.isBrandNew, this.price);
    }
}