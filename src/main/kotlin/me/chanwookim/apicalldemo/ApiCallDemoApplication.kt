package me.chanwookim.apicalldemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiCallDemoApplication

fun main(args: Array<String>) {
    runApplication<ApiCallDemoApplication>(*args)
}
