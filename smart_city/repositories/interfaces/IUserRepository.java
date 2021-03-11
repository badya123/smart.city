package com.smart_city.repositories.interfaces;

import com.smart_city.entities.User;

import java.util.List;

public interface IUserRepository {
    boolean createUser(User users);
    User getUser(int id);
    List<User> getAllUsers();
    boolean loginUser(String login, String password);
    boolean signUpUser(String username,String  password,String firstName,String lastName,
                       String education,String job,String business);
    boolean checkUsername(String username);
    boolean checkAdminRights(String userLogin);
    String getEducationInfo(String userLogin);
    String getJobInfo(String userLogin);
    String getBusinessInfo(String userLogin);
    boolean deleteUser(String userName);
    boolean giveAdmRights(String userName);
}
