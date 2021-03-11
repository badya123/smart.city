package com.smart_city.repositories.interfaces;

import com.smart_city.entities.Building;
import com.smart_city.entities.Train;

import java.util.List;

public interface ITrainRepository {
    boolean createTrain(Train buildings);
    Train getTrain(int id);
    List<Train> getAllTrains();
    String getTrainById(int id);
    boolean deleteTrain(int id);
}
