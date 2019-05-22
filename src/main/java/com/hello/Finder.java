package com.hello;

public class Finder {

    private final String content;
    private final char symbol;

    public Finder(String content, char symbol) {
        this.content = content;
        this.symbol = symbol;
    }

    public String getContent() {
        return "There is " + content + " " + symbol + " in row";
    }
}