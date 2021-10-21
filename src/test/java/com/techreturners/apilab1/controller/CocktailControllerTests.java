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

public class CocktailControllerTests {

    //This @Autowired is part of Spring
    //It enables objects(beans) to be injected at runtime by Spring Dependency Injection mechanism
    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testGetCocktail() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedContent = "Yummy cocktails - Happy Hour!";
        //Make a GET request to the '/cocktail' endpoint
        this.mockMvcController.perform(MockMvcRequestBuilders.get("/cocktaillover"))
                //Matchers are helpful methods that help you write your assertions
                //According to the requirement, we expect 200 OK Status Code as a Response
                //According to the requirement, we expect the string as a Response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetCocktailWithoutParams() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedValue = "Mai Tai";
        //Make a GET request to the '/coffee' endpoint
        this.mockMvcController.perform(MockMvcRequestBuilders.get("/cocktail"))
                //Matchers are helpful methods that help you write your assertions
                //According to the requirement, we expect 200 OK Status Code as a Response
                //According to the requirement, we expect the string as a Response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));
    }

    @Test
    public void testGetCocktailWithParams() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedValue = "Singapore Sling";
        //Make a GET request to the '/coffee' endpoint
        this.mockMvcController.perform(MockMvcRequestBuilders.get("/cocktail").param("name", "Singapore Sling"))
                //Matchers are helpful methods that help you write your assertions
                //According to the requirement, we expect 200 OK Status Code as a Response
                //According to the requirement, we expect the string as a Response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedValue));
    }
}
