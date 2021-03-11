package com.smart_city;

import com.smart_city.DB.PostgresDB;
import com.smart_city.DB.interfaces.IDB;
import com.smart_city.repositories.*;
import com.smart_city.repositories.interfaces.*;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IUserRepository repo1 = new UserRepository(db);
        IBuildingRepository repo2 = new BuildingRepository(db);
        ICurrencyRepository repo3 = new CurrencyRepository(db);
        ITrainRepository repo4 = new TrainRepository(db);
        IVacancyRepository repo5 = new VacancyRepository(db);
        Application app = new Application(repo1, repo2, repo3, repo4, repo5);
        app.start();
    }
}
