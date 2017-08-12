package com.kuleshov.web;

public enum View {
    LOGIN("login"),
    MAIN("main"),
    ERROR("error"),
    CATEGORY("category"),
    EMPLOYEE("employee");

    private String name;

    View(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
