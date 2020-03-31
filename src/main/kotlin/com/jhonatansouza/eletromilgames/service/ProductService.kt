package com.jhonatansouza.eletromilgames.service

import com.jhonatansouza.eletromilgames.repository.ProductItem
import org.springframework.stereotype.Service

@Service
class ProductService {

    fun createProduct(product:ProductItem):ProductItem{
        return product;
    }

}