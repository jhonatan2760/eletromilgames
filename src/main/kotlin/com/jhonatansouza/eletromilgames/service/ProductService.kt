package com.jhonatansouza.eletromilgames.service

import com.jhonatansouza.eletromilgames.repository.ProductItem
import com.jhonatansouza.eletromilgames.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService {

    val productRepository:ProductRepository;

    @Autowired
    constructor(productRepository: ProductRepository){
        this.productRepository = productRepository;
    }

    fun createProduct(product:ProductItem):ProductItem{
        this.productRepository.save(product);
        return product;
    }

}