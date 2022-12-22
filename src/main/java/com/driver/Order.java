package com.driver;

public class Order {

    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {

        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        int h1 = (int)deliveryTime.charAt(0)-'0';
        int h2 = (int)deliveryTime.charAt(1)-'0';
        int hh = h1*10+h2;
        int m1 = (int)deliveryTime.charAt(3)-'0';
        int m2 = (int)deliveryTime.charAt(4)-'0';
        int mm = m1*10+m2;
        this.id = id;
        this.deliveryTime = hh*60 + mm;
    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}
}
