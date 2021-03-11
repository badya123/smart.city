package com.smart_city.entities;

public class Train {
    private int id;
    private String departurePlace;
    private String arrivedPlace;
    private String departureTime;
    private String arrivedTime;
    private String description;

    public Train() {

    }

    public Train(String departurePlace, String arrivedPlace, String departureTime, String arrivedTime, String description) {
        this.departurePlace = departurePlace;
        this.arrivedPlace = arrivedPlace;
        this.departureTime = departureTime;
        this.arrivedTime = arrivedPlace;
        this.description = description;
    }

    public Train(int id, String departurePlace, String arrivedPlace, String departureTime, String arrivedTime, String description) {
        this.id = id;
        this.departurePlace = departurePlace;
        this.arrivedPlace = arrivedPlace;
        this.departureTime = departureTime;
        this.arrivedTime = arrivedPlace;
        this.description = description;
    }

    public Train(int id, String departurePlace, String arrivedPlace, String departureTime, String arrivedTime) {
        this.id = id;
        this.departurePlace = departurePlace;
        this.arrivedPlace = arrivedPlace;
        this.departureTime = departureTime;
        this.arrivedTime = arrivedPlace;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setArrivedPlace(String arrivedPlace) {
        this.arrivedPlace = arrivedPlace;
    }

    public void setArrivedTime(String arrivedTime) {
        this.arrivedTime = arrivedTime;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getArrivedPlace() {
        return arrivedPlace;
    }

    public String getArrivedTime() {
        return arrivedTime;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", departurePlace='" + departurePlace + '\'' +
                ", arrivedPlace='" + arrivedPlace + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivedTime='" + arrivedTime + '\'' +
                ", description='" + description + '\'' + '\n';
    }
}
