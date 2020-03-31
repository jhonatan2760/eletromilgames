package com.jhonatansouza.eletromilgames.controller.response

import com.jhonatansouza.eletromilgames.repository.ProductItem

class ProductResponse{

    var id:Long = 0;
    var name = ""
    var simpleDescription = ""
    var quantity = 0
    var isBrandNew = false
    var price = 0.00

    fun fromItem(productItem:ProductItem):ProductResponse{
        this.id = productItem.id
        this.name = productItem.name
        this.simpleDescription = productItem.simpleDescription
        this.quantity = productItem.quantity
        this.price = productItem.price
        this.isBrandNew = productItem.isBrandNew
        return this;
    }
}