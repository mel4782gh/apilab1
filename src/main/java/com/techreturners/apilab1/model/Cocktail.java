package com.techreturners.apilab1.model;

public class Cocktail {
    private final long id;
    private final String name;

    public Cocktail(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
