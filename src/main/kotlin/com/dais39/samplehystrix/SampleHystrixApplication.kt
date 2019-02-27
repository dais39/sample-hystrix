package com.dais39.samplehystrix

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
class SampleHystrixApplication{

    @Bean
    @LoadBalanced
    fun restTemplate(builder: RestTemplateBuilder) = builder.build()!!
}

fun main(args: Array<String>) {
    runApplication<SampleHystrixApplication>(*args)
}
