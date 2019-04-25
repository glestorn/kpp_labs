package com.hello;

public class Values {

    private String row;
    private String symbol;

    public Values() {}

    public Values(String row, char symbol) {
        this.row = row;
        this.symbol = "" + symbol;
    }

    public String getRow() { return row; }

    public char getSymbol() { return symbol.charAt(0); }

    public void setRow(String row) { this.row = row; }

    public void setSymbol(char symbol) { this.symbol = "" + symbol; }

}
