package Services;

import Domain.Car;

/**
 * Created by Riyaad on 8/13/2017.
 */
public interface CarService
{
    Car create(Car car1);
    Car read(String id);
    Car update(Car carDetails);
    void delete(String id);
}
