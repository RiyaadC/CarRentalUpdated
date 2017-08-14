package Repository.Impl;

import Domain.Car;
import Repository.CarRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class CarRepositoryImpl implements CarRepository {
    private static CarRepositoryImpl respository = null;

    private Map<String, Car> carTable;

    private CarRepositoryImpl()
    {
        carTable = new HashMap<String, Car>();
    }

    public static CarRepositoryImpl getInstance() {
        if (respository == null)
            respository = new CarRepositoryImpl();
        return respository;
    }

    public Car create(Car createCar) {
        carTable.put(createCar.getCarRegNo(), createCar);
        Car savedCar = carTable.get(createCar.getCarRegNo());
        return savedCar;
    }

    public Car read(String id) {
        Car car1 = carTable.get(id);
        return car1;
    }

    public Car update(Car updateCar) {
        carTable.put(updateCar.getCarRegNo(), updateCar);
        Car savedCar = carTable.get(updateCar.getCarRegNo());
        return savedCar;
    }

    public void delete(String id)
    {
        carTable.remove(id);


    }
}
