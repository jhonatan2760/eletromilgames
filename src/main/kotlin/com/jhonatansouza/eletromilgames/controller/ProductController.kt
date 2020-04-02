package com.jhonatansouza.eletromilgames.controller

import com.jhonatansouza.eletromilgames.controller.request.ProductRequest
import com.jhonatansouza.eletromilgames.controller.response.ProductResponse
import com.jhonatansouza.eletromilgames.repository.ProductItem
import com.jhonatansouza.eletromilgames.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class ProductController {

    val productService:ProductService;

    @Autowired
    constructor(productService: ProductService){
        this.productService = productService;
    }

    @PostMapping("/")
    fun createProduct(@RequestBody product:ProductRequest):ResponseEntity<ProductResponse>{
        val createdProduct = this.productService.createProduct(product.toItem());
        return ResponseEntity.ok(ProductResponse(createdProduct));
    }

    @GetMapping("/")
    fun listProduct() =
         ResponseEntity.ok(this.productService.listProducts())

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id:Long):ResponseEntity<Any>{
        val product = this.productService.getById(id);
        if(product.isPresent){
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id:Long):ResponseEntity<Any>{
        //validar se existia para dar 404 ou status de remoção
        this.productService.removeById(id)

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}