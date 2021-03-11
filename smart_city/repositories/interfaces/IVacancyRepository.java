package com.smart_city.repositories.interfaces;

import com.smart_city.entities.Building;
import com.smart_city.entities.Vacancy;

import java.util.List;

public interface IVacancyRepository {
    boolean createVacancy(Vacancy buildings);
    Vacancy getVacancy(int id);
    List<Vacancy> getAllVacancies();
    List<Vacancy> findVacancies(String jobF);
    boolean deleteVacancy(int id);
}
