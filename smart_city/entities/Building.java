package com.smart_city.entities;

public class Building {
    private int id;
    private String name;
    private String address;
    private double rating;
    private String schedule;
    private int type;
    private String additional;

    public Building(){

    }

    public Building(String name, String address, double rating, String schedule, int type, String additional){
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.schedule = schedule;
        this.type = type;
        this.additional = additional;
    }

    public Building(int id, String name, String address, double rating, String schedule, int type, String additional){
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.schedule = schedule;
        this.type = type;
        this.additional = additional;
    }

    public Building(int id, String name, String address, double rating, String schedule) {
        this.name = name;
        this.address = address;
        this.rating = rating;
        this.schedule = schedule;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public String getAddress() {
        return address;
    }

    public int getType() {
        return type;
    }

    public String getAdditional() {
        return additional;
    }

    public String getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rating=" + rating +
                ", schedule='" + schedule + '\'' + '\'' + '\n';
    }


}
