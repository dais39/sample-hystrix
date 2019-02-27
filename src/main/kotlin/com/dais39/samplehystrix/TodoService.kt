package com.dais39.samplehystrix

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.net.URI

@Service
class TodoService(val restTemplate: RestTemplate) {

    @HystrixCommand(fallbackMethod = "fallback")
    fun getTodo(): String{
        val res = restTemplate.getForObject(URI("http://eureka-client/service-instances"), Todo::class.java)
        return res?.name ?: "dais39"
    }

    fun fallback(throwable: Throwable): String {
        return "fallback: ${throwable.message}"
    }
}
