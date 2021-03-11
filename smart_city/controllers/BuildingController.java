package com.smart_city.controllers;

import com.smart_city.entities.Building;
import com.smart_city.repositories.interfaces.IBuildingRepository;

import java.util.List;

public class BuildingController {
    private final IBuildingRepository repo1;

    public BuildingController(IBuildingRepository repo1) {
        this.repo1 = repo1;
    }

    public String createBuilding(String name, String address, double rating, String schedule, int type, String additional){
        Building buildings = new Building(name, address, rating, schedule, type, additional);

        boolean created = repo1.createBuilding(buildings);
        return (created ? "Building was not created!" : "Building was created");
    }

    public String getBuilding(int id) {
        Building buildings =repo1.getBuilding(id);
        return (buildings == null? "Building was not found" : buildings.toString());
    }

    public String getAllBuildings() {
        List<Building> buildings = repo1.getAllBuildings();
        return buildings.toString();
    }

    public String getTopFiveRestaurants(){
        List<Building> buildings = repo1.getTopFiveRestaurants();
        return buildings.toString();
    }

    public String getMenu(int id){
        return repo1.getMenu(id);
    }

    public String getList(int type){
        List<Building> buildings = repo1.getList(type);
        return buildings.toString();
    }

    public boolean deleteBuilding(String buildingName){
        return repo1.deleteBuilding(buildingName);
    }
}
