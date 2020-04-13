package com.jhonatansouza.eletromilgames

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import kotlin.math.roundToInt
import kotlin.math.sqrt

@SpringBootApplication
class EletromilgamesApplication

fun main(args: Array<String>) {
	runApplication<EletromilgamesApplication>(*args)
}

/*
fun isPrime(a:Int):Boolean{

	val maxNumber = sqrt(a.toDouble()).roundToInt()
	println(maxNumber)
	for(i in 2..maxNumber){
		println("turno: ${i}")
		if(a % i == 0) return false

	}
	return true
}*/
