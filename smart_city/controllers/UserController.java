package com.smart_city.controllers;
import com.smart_city.entities.User;
import com.smart_city.repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController {
    private final IUserRepository repo1;

    public UserController(IUserRepository repo1) {
        this.repo1 = repo1;
    }

    public String createUser(String username, String password, boolean admrights){
        User users = new User(username, password, admrights);

        boolean created = repo1.createUser(users);
        return (created ? "User was created" : "User was not created!");
    }

    public String getUser(int id) {
        User users =repo1.getUser(id);
        return (users == null? "User was not found" : users.toString());
    }

    public String getAllUsers() {
        List<User> users = repo1.getAllUsers();
        return users.toString();
    }

    public boolean loginUser(String login, String password) {
        boolean loggined = repo1.loginUser(login, password);
        return loggined;
    }

    public boolean signUpUser(String username,String  password,String firstName,String lastName,
                              String education,String job,String business){
        boolean created = repo1.signUpUser(username, password, firstName, lastName, education, job, business);
        return created;
    }

    public boolean isInTable(String username){
        boolean isIn = repo1.checkUsername(username);
        return isIn;
    }

    public boolean checkAdminRights(String userLogin){
        boolean isAdmin = repo1.checkAdminRights(userLogin);
        return isAdmin;
    }

    public String getEducationInfo(String userLogin){
        return repo1.getEducationInfo(userLogin);
    }

    public String getJobInfo(String userLogin) {
        return repo1.getJobInfo(userLogin);
    }

    public String getBusinessInfo(String userLogin) {
        return repo1.getBusinessInfo(userLogin);
    }

    public boolean deleteUser(String userName){
        return repo1.deleteUser(userName);
    }

    public boolean giveAdmRights(String userName){
        return repo1.giveAdmRights(userName);
    }
}
