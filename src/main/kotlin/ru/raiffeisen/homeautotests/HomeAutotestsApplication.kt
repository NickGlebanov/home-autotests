package ru.raiffeisen.homeautotests

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HomeAutotestsApplication

fun main(args: Array<String>) {
	runApplication<HomeAutotestsApplication>(*args)
}
