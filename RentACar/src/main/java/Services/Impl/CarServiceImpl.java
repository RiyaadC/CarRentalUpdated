package Services.Impl;

import Domain.Car;
import Repository.Impl.CarRepositoryImpl;
import Repository.CarRepository;
import Services.CarService;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class CarServiceImpl implements CarService
{
    private static CarServiceImpl service = null;

    CarRepository repository = CarRepositoryImpl.getInstance();

    public static CarServiceImpl getInstance(){
        if(service == null)
            service = new CarServiceImpl();
        return service;
    }

    public Car create(Car createCar) {
        return repository.create(createCar);
    }

    public Car read(String id)
    {
        return repository.read(id);
    }

    public Car update(Car updateCar) {
        return repository.update(updateCar);
    }

    public void delete(String id)
    {
        repository.delete(id);

    }

}
