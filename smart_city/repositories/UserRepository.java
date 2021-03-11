package com.smart_city.repositories;
import com.smart_city.DB.interfaces.IDB;
import com.smart_city.entities.User;
import com.smart_city.repositories.interfaces.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserRepository implements IUserRepository {
    private final IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createUser(User users) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users(username,password, admright) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, users.getUsername());
            st.setString(2, users.getPassword());
            st.setBoolean(3, users.getAdmRights());

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
    public User getUser(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,username,password,admrights FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User users = new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("admrights"));

                return users;
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
    public List<User> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,username,password,admrights, firstname, " +
                    "lastname, currentjob, currenteducation, business FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("admrights"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("currentjob"),
                        rs.getString("currenteducation"),
                        rs.getString("business"));

                users.add(user);
            }

            return users;
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

    public boolean loginUser(String login, String password) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT password FROM users WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, login);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                String password2 = rs.getString("password");
                if(password.equals(password2)){
                    return true;
                }
                else {
                    return false;
                }
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
        return false;
    }

    @Override
    public boolean signUpUser(String username,String  password,String firstName,String lastName,
                              String education,String job,String business){
        Connection con = null;
        try {
            con = db.getConnection();

            String sql = "INSERT INTO users(username, password, admrights, firstname," +
                    "lastname, currentjob, currenteducation, business) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, username);
            st.setString(2, password);
            st.setBoolean(3, false);
            st.setString(4, firstName);
            st.setString(5, lastName);
            st.setString(6, job);
            st.setString(7, education);
            st.setString(8, business);

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

    public boolean checkUsername(String username) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT username FROM users WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return false;
            }
            return true;
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

    public boolean checkAdminRights(String userLogin){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT admrights FROM users WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, userLogin);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                boolean isAdmin = rs.getBoolean("admrights");
                return isAdmin;
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
        return false;
    }

    public String getEducationInfo(String username){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT currenteducation FROM users WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getString("currenteducation");
            }
            return null;
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

    public String getJobInfo(String username){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT currentjob FROM users WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getString("currentjob");
            }
            return null;
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

    public String getBusinessInfo(String username){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT business FROM users WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getString("business");
            }
            return null;
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

    public boolean deleteUser(String userName){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM users WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, userName);

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

    public boolean giveAdmRights(String userName){
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE users SET admrights=true WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, userName);

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
