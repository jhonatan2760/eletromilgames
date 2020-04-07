package com.jhonatansouza.eletromilgames.service

import com.jhonatansouza.eletromilgames.repository.ProductItem
import com.jhonatansouza.eletromilgames.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.Exception
import java.util.*

@Service
class ProductService {

    val productRepository:ProductRepository;

    @Autowired
    constructor(productRepository: ProductRepository){
        this.productRepository = productRepository;
    }

    fun createProduct(product:ProductItem):ProductItem =
        this.productRepository.save(product)

    fun listProducts():Iterable<ProductItem> =
            this.productRepository.findAll()


    fun getById(id:String): Optional<ProductItem> =
        this.productRepository.findById(id);


    fun removeById(id:String):Boolean{
        return if(this.productRepository.existsById(id)){
            this.productRepository.deleteById(id)
            this.productRepository.existsById(id);
        }else{
            false;
        }
    }

    @Throws(Exception::class)
    fun updateById(product:ProductItem):ProductItem{
        return if(this.productRepository.existsById(product.id.orEmpty())){
            this.productRepository.save(product)
        }else{
            throw object : Exception("The product doest exist"){}
        }
    }
}