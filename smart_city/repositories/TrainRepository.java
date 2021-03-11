package com.smart_city.repositories;

import com.smart_city.DB.interfaces.IDB;
import com.smart_city.entities.Building;
import com.smart_city.entities.Train;
import com.smart_city.repositories.interfaces.ITrainRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainRepository implements ITrainRepository {
    private final IDB db;

    public TrainRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createTrain(Train trains) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO trainschedule(departureplace, arrivedplace, departuretime, arrivedtime, description)" +
                    " VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, trains.getDeparturePlace());
            st.setString(2, trains.getArrivedPlace());
            st.setString(3, trains.getDepartureTime());
            st.setString(4, trains.getArrivedTime());
            st.setString(5, trains.getDescription());

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
    public Train getTrain(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, departureplace, arrivedplace, departuretime, arrivedtime, " +
                    "description FROM trainschedule WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Train trains = new Train(rs.getInt("id"),
                        rs.getString("departureplace"),
                        rs.getString("arrivedplace"),
                        rs.getString("departuretime"),
                        rs.getString("arrivedtime"),
                        rs.getString("description"));

                return trains;
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
    public List<Train> getAllTrains() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, departureplace, arrivedplace, departuretime, arrivedtime FROM trainschedule";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Train> trains = new ArrayList<>();
            while (rs.next()) {
                Train train = new Train(rs.getInt("id"),
                        rs.getString("departureplace"),
                        rs.getString("arrivedplace"),
                        rs.getString("departuretime"),
                        rs.getString("arrivedtime"));

                trains.add(train);
            }

            return trains;
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
    public String getTrainById(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT description FROM trainschedule WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String train =
                        rs.getString("description");

                return train;
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

    public boolean deleteTrain(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM trainschedule WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

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
