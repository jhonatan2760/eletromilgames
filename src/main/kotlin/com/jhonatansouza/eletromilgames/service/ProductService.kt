package com.jhonatansouza.eletromilgames.service

import com.jhonatansouza.eletromilgames.controller.request.ProductRequest
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

    fun getById(id:String): Optional<ProductItem> {
        return this.productRepository.findById(id);
    }

    fun removeById(id:String):Boolean{
        return if(this.getById(id).isPresent){
            this.productRepository.deleteById(id)
            true;
        }else{
            false;
        }
    }

    fun updateById(id:String, product:ProductItem):Optional<ProductItem>{
       val prd = this.getById(id);
        if(this.productRepository.existsById(id)){
            //product.id = prd.get().id
            product.id = id
            val prod = this.productRepository.save(product)
            return Optional.of(prod)
        }

        return Optional.empty()
    }
}