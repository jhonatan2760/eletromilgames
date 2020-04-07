package com.jhonatansouza.eletromilgames.repository

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "products")
data class ProductItem(@Id val id:String? = null, val name:String , val simpleDescription:String,
                  val quantity:Int,
                  val isBrandNew:Boolean,
                  val price:Double)