package com.smart_city.repositories;

import com.smart_city.DB.interfaces.IDB;
import com.smart_city.entities.Building;
import com.smart_city.entities.Currency;
import com.smart_city.repositories.interfaces.ICurrencyRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyRepository implements ICurrencyRepository {
    private final IDB db;

    public CurrencyRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCurrency(Currency currencies) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO currency(currencyname1,currency1, currencyname2,currency2, growthcoefficient)" +
                    " VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, currencies.getNameCurrency1());
            st.setDouble(2, currencies.getCurrency1());
            st.setString(3, currencies.getNameCurrency2());
            st.setDouble(4, currencies.getCurrency2());
            st.setDouble(5, currencies.getGrowthCoefficient());

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
    public Currency getCurrency(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,currencyname1,currency1, currencyname2,currency2, growthcoefficient FROM currency WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Currency currencies = new Currency(rs.getInt("id"),
                        rs.getString("currencyname1"),
                        rs.getDouble("currency1"),
                        rs.getString("currencyname2"),
                        rs.getDouble("currency2"),
                        rs.getDouble("growthcoefficient"));

                return currencies;
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
    public List<Currency> getAllCurrencies() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,currencyname1,currency1, currencyname2,currency2, growthcoefficient FROM currency";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Currency> currencies = new ArrayList<>();
            while (rs.next()) {
                Currency currency = new Currency(rs.getInt("id"),
                        rs.getString("currencyname1"),
                        rs.getDouble("currency1"),
                        rs.getString("currencyname2"),
                        rs.getDouble("currency2"),
                        rs.getDouble("growthcoefficient"));

                currencies.add(currency);
            }

            return currencies;
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

    public boolean deleteCurrency(String currencyName){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM currency WHERE currencyname1=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, currencyName);

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
