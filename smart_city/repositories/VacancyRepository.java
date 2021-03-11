package com.smart_city.repositories;

import com.smart_city.DB.interfaces.IDB;
import com.smart_city.entities.Building;
import com.smart_city.entities.Vacancy;
import com.smart_city.repositories.interfaces.IVacancyRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancyRepository implements IVacancyRepository {
    private final IDB db;

    public VacancyRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createVacancy(Vacancy vacancies) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO laboursearcher(jobname, companyname, address, salary, experience, additional) " +
                    "VALUES (?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, vacancies.getJobName());
            st.setString(2, vacancies.getCompanyName());
            st.setString(3, vacancies.getAddress());
            st.setDouble(4, vacancies.getSalary());
            st.setInt(5, vacancies.getExperience());
            st.setString(6, vacancies.getAdditional());

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
    public Vacancy getVacancy(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT jobname, companyname, address, salary, experience, additional " +
                    "FROM laboursearcher WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Vacancy vacancies = new Vacancy(rs.getInt("id"),
                        rs.getString("jobname"),
                        rs.getString("companyname"),
                        rs.getDouble("salary"),
                        rs.getString("address"),
                        rs.getInt("experience"),
                        rs.getString("additional"));

                return vacancies;
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
    public List<Vacancy> getAllVacancies() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,jobname, companyname, address, salary, experience, additional FROM laboursearcher";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Vacancy> vacancies = new ArrayList<>();
            while (rs.next()) {
                Vacancy vacancy = new Vacancy(rs.getInt("id"),
                        rs.getString("jobname"),
                        rs.getString("companyname"),
                        rs.getDouble("salary"),
                        rs.getString("address"),
                        rs.getInt("experience"),
                        rs.getString("additional"));

                vacancies.add(vacancy);
            }

            return vacancies;
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

    public List<Vacancy> findVacancies(String jobF){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,jobname, companyname, address, salary, experience, additional FROM laboursearcher" +
                    " WHERE jobname=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, jobF);

            ResultSet rs = st.executeQuery();
            List<Vacancy> vacancies = new ArrayList<>();
            while (rs.next()) {
                Vacancy vacancy = new Vacancy(rs.getInt("id"),
                        rs.getString("jobname"),
                        rs.getString("companyname"),
                        rs.getDouble("salary"),
                        rs.getString("address"),
                        rs.getInt("experience"),
                        rs.getString("additional"));

                vacancies.add(vacancy);
            }

            return vacancies;
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

    public boolean deleteVacancy(int id){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM laboursearcher WHERE id=?";
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
