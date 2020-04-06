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
    fun createProduct(@RequestBody product:ProductRequest):ResponseEntity<ProductItem>{
        val createdProduct = this.productService.createProduct(product.toItem());
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping("/")
    fun listProduct() =
         ResponseEntity.ok(this.productService.listProducts())

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id:String):ResponseEntity<Any>{
        val product = this.productService.getById(id);
        if(product.isPresent){
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id:String):ResponseEntity<Any>{
        return if(this.productService.removeById(id)){
                ResponseEntity.ok().build()
        }else{
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun updateById(@PathVariable id:String, @RequestBody product:ProductRequest):ResponseEntity<Any> {

        this.productService.updateById(id, product.toItem())

        return ResponseEntity.ok().build()
    }

    @GetMapping("/upper")
    fun productToUpper():ResponseEntity<String>{

        val products = listOf("play station 2", "play station 4", "game boy advance",
        "game boy color", "nintendo game cube", "nintendo switch")

        mapOf(1 to "first", 2 to "second", 3 to "Jhonatan")
                .filter { (k, v) -> v.equals("Jhonatan") }


        return ResponseEntity.ok(products.reduce { acc, s -> "$acc, $s" })
    }

}