package com.jhonatansouza.eletromilgames

import com.jhonatansouza.eletromilgames.controller.request.ProductRequest
import com.jhonatansouza.eletromilgames.controller.response.ProductResponse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EletromilgamesApplicationTests {


	@Autowired
	lateinit var testRestTemplate: TestRestTemplate

	@Test
	fun contextLoads() {
	}

	@Test
	fun createProductTest(){
		val result = this.testRestTemplate
							.getForEntity("/product/upper", String::class.java)

		println(result)
		assertNotNull(result)
	}

	@Test
	fun shouldCreateProduct(){

		val result = this.testRestTemplate
							.postForEntity("/product/",
									this.dummyProduct(),
									ProductRequest::class.java)

		assert(result.statusCode.is2xxSuccessful)

	}

	@Test
	@DisplayName("finding all products")
	fun shouldGetAllProducts(){

		val result = this.testRestTemplate.getForEntity("/product/", Iterable::class.java)

		println(result)
		assertNotNull(result)

	}

	fun dummyProduct():ProductRequest{
		return ProductRequest(name = "Xbox One", simpleDescription = "Xbox Console",
			quantity = 2, brand_new = true, price = 100.0)
	}
}
