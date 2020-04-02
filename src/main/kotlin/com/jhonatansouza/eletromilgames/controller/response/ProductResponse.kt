package com.jhonatansouza.eletromilgames.controller.response

import com.jhonatansouza.eletromilgames.repository.ProductItem

data class ProductResponse(val id:Long,
val name:String,
val simpleDescription:String,
val quantity:Int,
val isBrandNew:Boolean,
val price:Double){

    constructor(productItem:ProductItem) : this(id = productItem.id, name = productItem.name,
            simpleDescription = productItem.simpleDescription,
            quantity = productItem.quantity, price = productItem.price, isBrandNew = productItem.isBrandNew);

}