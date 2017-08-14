package com.rentacar.Services;

import Domain.Car;
import Factories.CarFactory;
import Services.CarService;
import Services.Impl.CarServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class CarServiceTest {
    CarService service;
    Map<String,String> values;
    
    @BeforeMethod
    public void setUp() throws Exception 
    {

        service = CarServiceImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("carName","BMW");
        values.put("carModel","318i");
        values.put("carYear","2006");
    }

    @Test
    public void Create() throws Exception
    {
        Car car1 = CarFactory.getCarDetails(values,"CY101");
        service.create(car1);
        assertEquals("CY101",car1.getCarRegNo());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception
    {
        Car readCar = service.read("CY101");
        assertEquals("CY101",readCar.getCarRegNo());
    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception
    {
        Car car1 = service.read("CY101");
        Car bk1 = new Car.Builder()
                .carRegNo("CY101")
                .carModel("315")
                .carName("Honda")
                .carYear("2006")
                .build();
        service.update(bk1);
        Car UpdateCar = service.read("CY101");
        assertEquals("Honda",UpdateCar.getCarName());
    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception
    {
        service.delete("CY101");
        Car car1 = service.read("CY101");
        assertNull(car1);
    }


}