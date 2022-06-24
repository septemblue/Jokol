package com.example.jokol;

public class Shop {

    private int image;
    private String shopName;
    private int price;
    private float rateBar;
    private String rate;
    private int user;
    private String description;


    public Shop(int image, String shopName, int price, float rateBar, String rate, int user, String description) {
        this.image = image;
        this.shopName = shopName;
        this.price = price;
        this.rateBar = rateBar;
        this.rate = rate;
        this.user = user;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "image=" + image +
                ", shopName='" + shopName + '\'' +
                ", price=" + price +
                ", rateBar=" + rateBar +
                ", rate='" + rate + '\'' +
                ", user=" + user +
                ", description='" + description + '\'' +
                '}';
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getRateBar() {
        return rateBar;
    }

    public void setRateBar(float rateBar) {
        this.rateBar = rateBar;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

