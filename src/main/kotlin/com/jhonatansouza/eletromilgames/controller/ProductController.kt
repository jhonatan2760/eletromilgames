package com.jhonatansouza.eletromilgames.controller

import org.springframework.web.util.UriComponentsBuilder
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

    @Autowired
    lateinit var productService: ProductService;

    @PostMapping("/")
    fun createProduct(@RequestBody product: ProductRequest, uri: UriComponentsBuilder): ResponseEntity<Any> =
            this.productService.createProduct(product.toItem()).let { p ->  ResponseEntity
                        .created(uri.path("/{id}").build(p.id))
                        .body(p)}



    @GetMapping("/")
    fun listProduct() =
            ResponseEntity.ok(this.productService.listProducts())

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: String): ResponseEntity<Any> {
        val product = this.productService.getById(id);
        if (product.isPresent) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: String): ResponseEntity<Any> {
        return if (this.productService.removeById(id)) {
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/")
    fun updateById(@RequestBody product: ProductRequest): ResponseEntity<Any> =
            ResponseEntity.ok(this.productService.updateById(product.toItem()))

    @GetMapping("/upper")
    fun productToUpper(): ResponseEntity<String> {

        val products = listOf("play station 2", "play station 4", "game boy advance",
                "game boy color", "nintendo game cube", "nintendo switch")

        mapOf(1 to "first", 2 to "second", 3 to "Jhonatan")
                .filter { (k, v) -> v.equals("Jhonatan") }


        return ResponseEntity.ok(products.reduce { acc, s -> "$acc, $s" })
    }
}




