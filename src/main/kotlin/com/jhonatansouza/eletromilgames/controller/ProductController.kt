package com.jhonatansouza.eletromilgames.controller

import com.jhonatansouza.eletromilgames.controller.request.ProductRequest
import com.jhonatansouza.eletromilgames.controller.response.ProductResponse
import com.jhonatansouza.eletromilgames.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
        return ResponseEntity.ok(ProductResponse().fromItem(createdProduct));
    }

}