package com.sabbath.calculator

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class CalculatorTest {
    @Autowired
    lateinit var calculator: Calculator

    @Test
    fun testSum() = assertEquals(5, calculator.sum(2, 3))
}