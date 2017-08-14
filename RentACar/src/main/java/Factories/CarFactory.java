package Factories;

import Domain.Car;

import java.util.Map;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class CarFactory
{
    public static Car getCarDetails(Map<String, String> values,String carReg)
    {
        Car car1 = new Car.Builder()
                .carName(values.get("carName"))
                .carModel(values.get("carModel"))
                .carRegNo(carReg)
                .carYear(values.get("carYear")).build();
        return car1;
    }



}
