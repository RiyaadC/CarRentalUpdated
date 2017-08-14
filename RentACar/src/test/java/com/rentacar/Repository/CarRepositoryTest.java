package com.rentacar.Repository;


import Domain.Car;
import Factories.CarFactory;
import Repository.CarRepository;
import Repository.Impl.CarRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class CarRepositoryTest {
    CarRepository repository;
    Map<String,String> values;
    @BeforeMethod
    public void setUp() throws Exception
    {
        repository = CarRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("carName","BMW");
        values.put("carModel","318i");
        values.put("carYear","2006");
    }

    @Test
    public void Create() throws Exception
    {
        Car car1 = CarFactory.getCarDetails(values,"CY101");
        repository.create(car1);
        assertEquals("CY101",car1.getCarRegNo());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception
    {
        Car readCar = repository.read("CY102");
        assertEquals("CY101",readCar.getCarRegNo());
    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception
    {
        Car car1 = repository.read("CY102");
        Car bk1 = new Car.Builder()
                .carRegNo("CY102")
                .carModel("315")
                .carName("Honda")
                .carYear("2006")
                .build();
        repository.update(bk1);
        Car UpdateCar = repository.read("CY102");
        assertEquals("Honda",UpdateCar.getCarName());
    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception
    {
        repository.delete("CY101");
        Car car1 = repository.read("CY101");
        assertNull(car1);
    }

}