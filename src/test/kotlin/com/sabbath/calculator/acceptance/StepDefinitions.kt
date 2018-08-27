package com.sabbath.calculator.acceptance

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import junit.framework.Assert.assertEquals
import org.springframework.web.client.RestTemplate

class StepDefinitions {
    val server = System.getProperty("calculator.url")
    val restTemplate = RestTemplate()
    var a: String = ""
    var b: String = ""
    var result = ""

    @Given("^I have two numbers: (.*) and (.*)$")
    fun `i have two numbers`(a: String, b: String) {
        this.a = a
        this.b = b
    }

    @When("^the calculator sums them$")
    fun `the calculator sums them`() {
        result=restTemplate.getForObject("$server/sum?a=$a&b=$b", String::class.java)?:""
    }

    @Then("^I receive (.*) as a result$")
    fun `i receive as a result`(expectedResult:String){
        assertEquals(expectedResult,result)
    }



}