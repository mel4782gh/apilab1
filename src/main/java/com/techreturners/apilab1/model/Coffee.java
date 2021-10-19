package com.techreturners.apilab1.model;

public class Coffee {
    private final long id;
    private final String name;

    public Coffee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getname() {
        return name;
    }
}
