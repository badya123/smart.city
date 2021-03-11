package com.smart_city.entities;

public class User {
    private int id;
    private String username;
    private String password;
    private boolean admrights;
    private String firstname;
    private String lastname;
    private String currentjob;
    private String currenteducation;
    private String business;

    public User() {

    }

    public User(String username, String password, boolean admRights) {
        this.username = username;
        this.password = password;
        this.admrights = admRights;
    }

    public User(int id, String username, String password, boolean admRights) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.admrights = admRights;
    }

    public User(int id, String username, String password, boolean admrights, String firstname,
                String lastname, String currentjob, String currenteducation, String business) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.admrights = admrights;
        this.currentjob = currentjob;
        this.currenteducation = currenteducation;
        this.business = business;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getAdmRights() {
        return admrights;
    }

    public String getBusiness() {
        return business;
    }

    public String getCurrenteducation() {
        return currenteducation;
    }

    public String getCurrentjob() {
        return currentjob;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public void setCurrentjob(String currentjob) {
        this.currentjob = currentjob;
    }

    public void setCurrenteducation(String currenteducation) {
        this.currenteducation = currenteducation;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmRights(boolean admRights) {
        this.admrights = admRights;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", admrights=" + admrights +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", currentjob='" + currentjob + '\'' +
                ", currenteducation='" + currenteducation + '\'' +
                ", business='" + business + '\n';
    }
}
