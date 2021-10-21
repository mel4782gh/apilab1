package com.techreturners.apilab1.controller;
import com.techreturners.apilab1.model.Coffee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.techreturners.apilab1.model.Cocktail;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CocktailController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping(value = "/cocktaillover")
    public String cocktail() {
        return "Yummy cocktails - Happy Hour!";
    }

    @GetMapping("/cocktail")
    public Cocktail cocktail(@RequestParam(value = "name", defaultValue = "Mai Tai") String name) {
        return new Cocktail(counter.incrementAndGet(), name);
    }
}
