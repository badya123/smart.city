package com.smart_city.repositories;

import com.smart_city.DB.interfaces.IDB;
import com.smart_city.entities.Building;
import com.smart_city.entities.User;
import com.smart_city.repositories.interfaces.IBuildingRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BuildingRepository implements IBuildingRepository {
    private final IDB db;

    public BuildingRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createBuilding(Building buildings) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO buildings(name, address, rating, schedule, type, additional) VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, buildings.getName());
            st.setString(2, buildings.getAddress());
            st.setDouble(3, buildings.getRating());
            st.setString(4, buildings.getSchedule());
            st.setInt(5, buildings.getType());
            st.setString(6, buildings.getAdditional());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Building getBuilding(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,address, rating, schedule, type, additional FROM buildings WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Building buildings = new Building(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDouble("rating"),
                        rs.getString("schedule"),
                        rs.getInt("type"),
                        rs.getString("additional"));

                return buildings;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Building> getAllBuildings() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,address, rating, schedule, type, additional FROM buildings";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Building> buildings = new ArrayList<>();
            while (rs.next()) {
                Building building = new Building(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDouble("rating"),
                        rs.getString("schedule"),
                        rs.getInt("type"),
                        rs.getString("additional"));

                buildings.add(building);
            }

            return buildings;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public List<Building> getTopFiveRestaurants() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, address, rating, schedule FROM buildings WHERE " +
                    "type = 5 ORDER BY rating DESC LIMIT 5";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Building> buildings = new ArrayList<>();
            while (rs.next()) {
                Building building = new Building(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDouble("rating"),
                        rs.getString("schedule"));

                buildings.add(building);
            }

            return buildings;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public String getMenu(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT additional FROM buildings WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String menu = rs.getString("additional");

                return menu;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Building> getList(int type) {
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "SELECT id, name, address, rating, schedule FROM buildings WHERE type=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, type);

            ResultSet rs = st.executeQuery();
            List<Building> buildings = new ArrayList<>();
            while (rs.next()) {
                Building building = new Building(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getDouble("rating"),
                        rs.getString("schedule"));

                buildings.add(building);
            }

            return buildings;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    public boolean deleteBuilding(String buildingName){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM buildings WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, buildingName);

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
