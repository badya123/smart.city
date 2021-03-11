package com.smart_city.controllers;

import com.smart_city.entities.Vacancy;
import com.smart_city.repositories.interfaces.IVacancyRepository;

import java.util.List;

public class VacancyController {
    private final IVacancyRepository repo1;

    public VacancyController(IVacancyRepository repo1) {
        this.repo1 = repo1;
    }

    public String createVacancy(String jobName, String companyName, double salary, String address, int experience, String additional){
        Vacancy vacancies = new Vacancy(jobName, companyName, salary, address, experience, additional);

        boolean created = repo1.createVacancy(vacancies);
        return (created ? "Vacancy was created" : "Vacancy was not created!");
    }

    public String getVacancy(int id) {
        Vacancy vacancies =repo1.getVacancy(id);
        return (vacancies == null? "Vacancy was not found" : vacancies.toString());
    }

    public String getAllVacancies() {
        List<Vacancy> vacancies = repo1.getAllVacancies();
        return vacancies.toString();
    }

    public String findVacancies(String jobF){
        List<Vacancy> vacancies = repo1.findVacancies(jobF);
        return vacancies.toString();
    }

    public boolean deleteVacancy(int id){
        return repo1.deleteVacancy(id);
    }

}
