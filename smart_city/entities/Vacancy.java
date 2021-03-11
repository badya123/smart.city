package com.smart_city.entities;

public class Vacancy {
    private int id;
    private String jobName;
    private double salary;
    private String address;
    private int experience;
    private String additional;
    private String companyName;

    public Vacancy(){

    }

    public Vacancy(String jobName, String companyName, double salary, String address, int experience, String additional){
        this.jobName = jobName;
        this.companyName = companyName;
        this.salary = salary;
        this.address = address;
        this.experience = experience;
        this.additional = additional;
    }

    public Vacancy(int id, String jobName, String companyName, double salary, String address, int experience, String additional){
        this.id = id;
        this.jobName = jobName;
        this.salary = salary;
        this.address = address;
        this.experience = experience;
        this.additional = additional;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAdditional() {
        return additional;
    }

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public int getExperience() {
        return experience;
    }

    public String getJobName() {
        return jobName;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", jobName='" + jobName + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", experience=" + experience +
                ", additional='" + additional + '\'' +
                ", companyName='" + companyName + '\'' + '\n';
    }
}
