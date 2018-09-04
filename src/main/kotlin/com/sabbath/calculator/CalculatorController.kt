package com.sabbath.calculator

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CalculatorController(val calculator: Calculator) {
    @GetMapping("/sum")
    fun sum(
            @RequestParam("a") a: Int,
            @RequestParam("b") b: Int
    ) = calculator.sum(a, b)

    @GetMapping("/test")
    fun test()="Hello!"

}
