package com.smart_city.repositories.interfaces;

import com.smart_city.entities.Building;

import java.util.List;

public interface IBuildingRepository {
    boolean createBuilding(Building buildings);
    Building getBuilding(int id);
    List<Building> getAllBuildings();
    List<Building> getTopFiveRestaurants();
    String getMenu(int id);
    List<Building> getList(int type);
    boolean deleteBuilding(String buildingName);
}
