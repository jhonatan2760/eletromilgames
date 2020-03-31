package com.jhonatansouza.eletromilgames.repository

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

    var id = 0;
    var name = ""
    var simpleDescription = ""
    var quantity = 0
    var isBrandNew = false
    var price = 0.00

}