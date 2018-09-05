package com.sabbath.calculator

import org.springframework.stereotype.Service

@Service
class Calculator {
    fun sum(a: Int, b: Int) = a + b +5
}