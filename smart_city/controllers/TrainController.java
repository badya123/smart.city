package com.smart_city.controllers;

import com.smart_city.entities.Train;
import com.smart_city.entities.Vacancy;
import com.smart_city.repositories.interfaces.ITrainRepository;

import java.util.List;

public class TrainController {
    private final ITrainRepository repo1;

    public TrainController(ITrainRepository repo1) {
        this.repo1 = repo1;
    }

    public String createTrain(String departurePlace, String arrivedPlace, String departureTime,
                              String arrivedTime, String description){
        Train trains = new Train(departurePlace, arrivedPlace, departureTime, arrivedTime, description);

        boolean created = repo1.createTrain(trains);
        return (created ? "Train was created" : "Train was not created!");
    }

    public String getTrain(int id) {
        String train =repo1.getTrainById(id);
        return (train == null? "Train was not found" : train);
    }

    public String getAllTrains() {
        List<Train> trains = repo1.getAllTrains();
        return trains.toString();
    }

    public boolean deleteTrain(int id){
        return repo1.deleteTrain(id);
    }
}
