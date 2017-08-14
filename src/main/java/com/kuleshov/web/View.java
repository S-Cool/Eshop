package com.kuleshov.web;

public enum View {
    LOGIN("login"),
    MAIN("main"),
    ERROR("error"),
    USER("category");

    private String name;

    View(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
