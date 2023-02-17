package com.example.di2.coffee;

public class Coffee {
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;

    public Coffee(long coffeeId, String korname, String engName, int price) {
        this.coffeeId = coffeeId;
        this.korName = korname;
        this.engName = engName;
        this.price = price;
    }

    public long getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public String getKorName() {
        return korName;
    }

    public void setkorName(String korName) {
        this.korName = korName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
