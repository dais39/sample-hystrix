package com.dais39.samplehystrix

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HystrixController(val service: TodoService) {

    @GetMapping("/")
    fun hello(): String {
        return service.getTodo()
    }
}
