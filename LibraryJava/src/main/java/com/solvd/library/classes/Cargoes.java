package com.solvd.library.classes;

import java.util.Date;

public class Cargoes {

    private Long id = null;

    private String country;

    private int items;

    private int weight;

    private Date date;  //CHECK this type because i never used it

    public Cargoes(Long id, String country, int items, int weight, Date date) {
        this.id = id;
        this.country = country;
        this.items = items;
        this.weight = weight;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getItems() {
        return items;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
