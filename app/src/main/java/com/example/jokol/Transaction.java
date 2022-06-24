package com.example.jokol;

public class Transaction {

    private int transImage;
    private String transName;
    private String transTotal;
    private String transPrice;


    public Transaction(int transImage, String transName, String transTotal, String transPrice) {
        this.transImage = transImage;
        this.transName = transName;
        this.transTotal = transTotal;
        this.transPrice = transPrice;
    }


    public int getTransImage() {
        return transImage;
    }

    public void setTransImage(int transImage) {
        this.transImage = transImage;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getTransTotal() {
        return transTotal;
    }

    public void setTransTotal(String transTotal) {
        this.transTotal = transTotal;
    }

    public String getTransPrice() {
        return transPrice;
    }

    public void setTransPrice(String transPrice) {
        this.transPrice = transPrice;
    }

}
