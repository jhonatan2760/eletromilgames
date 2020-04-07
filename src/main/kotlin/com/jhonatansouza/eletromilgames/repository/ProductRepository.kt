package com.jhonatansouza.eletromilgames.repository

import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<ProductItem, String> {
}