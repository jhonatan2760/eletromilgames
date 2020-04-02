package com.jhonatansouza.eletromilgames.repository

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "products")
class ProductItem {

    constructor(name:String , simpleDescription:String,
                quantity:Int,
                isBrandNew:Boolean,
                price:Double){
        this.name = name;
        this.quantity = quantity;
        this.simpleDescription = simpleDescription;
        this.isBrandNew = isBrandNew;
        this.price = price;
    }

    @Id
    var id:Long = 0;
    var name = ""
    var simpleDescription = ""
    var quantity = 0
    var isBrandNew = false
    var price = 0.00

}