package com.techreturners.apilab1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//The @AutoConfigureMockMvc is an annotation
//It tells the test class to enable and configure auto-configuration of MockMvc
// MockMvc is the Main entry point for server-side Spring MVC testing
// It is useful because you can test the controller without running the controller within a server
@AutoConfigureMockMvc
@SpringBootTest

public class CoffeeControllerTests {
    //This @Autowired is part of Spring
    //It enables objects(beans) to be injected at runtime by Spring Dependency Injection mechanism
    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testGetCoffeeLover() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedContent = "I like coffee!";
        //Make a GET request to the '/coffeelover' endpoint
        this.mockMvcController.perform(MockMvcRequestBuilders.get("/coffeelover"))
                //Matchers are helpful methods that help you write your assertions
                //According to the requirement, we expect 200 OK Status Code as a Response
                //According to the requirement, we expect the string as a Response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetCoffeeWithoutParams() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedValue = "latte";
        //Make a GET request to the '/coffee' endpoint
        this.mockMvcController.perform(MockMvcRequestBuilders.get("/coffee"))
                //Matchers are helpful methods that help you write your assertions
                //According to the requirement, we expect 200 OK Status Code as a Response
                //According to the requirement, we expect the string as a Response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));
    }

    @Test
    public void testGetCoffeeWithParams() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedValue = "cappuccino";
        //Make a GET request to the '/coffee' endpoint
        this.mockMvcController.perform(MockMvcRequestBuilders.get("/coffee").param("name", "cappuccino"))
                //Matchers are helpful methods that help you write your assertions
                //According to the requirement, we expect 200 OK Status Code as a Response
                //According to the requirement, we expect the string as a Response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));
    }
}