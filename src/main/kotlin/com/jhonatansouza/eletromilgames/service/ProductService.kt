package com.jhonatansouza.eletromilgames.service

import com.jhonatansouza.eletromilgames.repository.ProductItem
import com.jhonatansouza.eletromilgames.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

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

    fun listProducts():Iterable<ProductItem>{
       return this.productRepository.findAll()
    }

    fun getById(id:Long): Optional<ProductItem> {
        return this.productRepository.findById(id);
    }


}