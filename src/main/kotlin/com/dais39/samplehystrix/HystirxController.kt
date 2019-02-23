package com.dais39.samplehystrix

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class HystirxController(private val builder: RestTemplateBuilder) {

    @LoadBalanced
    val restTemplate = builder.build()

    @GetMapping("/")
    @HystrixCommand(fallbackMethod = "fallback")
    fun hello(): String {
        val res = restTemplate.getForObject(URI("http://eureka-client/"), Todo::class.java)
        return res?.name ?: "dais39"
    }

    fun fallback(throwable: Throwable): String {
        return "fallback"
    }
}
