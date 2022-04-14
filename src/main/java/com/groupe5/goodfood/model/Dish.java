package com.groupe5.goodfood.model;

public class Dish {
    private String id;
    private  String name;
    private double price;

    public  Dish(String id, String name, double price ){
        this.id = id ;
        this.name = name;
        this.price = price;
    }


    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }




}
