package com.dais39.samplehystrix

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class SampleHystrixApplication

fun main(args: Array<String>) {
    runApplication<SampleHystrixApplication>(*args)
}
