package com.rentacar.Factories;

import Domain.Car;
import Factories.CarFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class CarFactoryTest
{
    Map<String,String> values;
    @BeforeMethod
    public void setUp() throws Exception
    {
        values = new HashMap<String, String>();
        values.put("carName","BMW");
        values.put("carModel","318i");
        values.put("carYear","2006");
    }

    @Test
    public void testGetCarDetails() throws Exception
    {
        Car car = CarFactory.getCarDetails(values,"CY101");
        assertEquals("CY101",car.getCarRegNo());

    }
}