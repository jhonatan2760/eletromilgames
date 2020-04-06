package com.jhonatansouza.eletromilgames.repository

import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<ProductItem, String> {
}