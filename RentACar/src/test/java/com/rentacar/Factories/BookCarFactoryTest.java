package com.rentacar.Factories;

import Domain.BookCar;
import Factories.BookCarFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class BookCarFactoryTest {
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception {

        values = new HashMap<String, String>();
        values.put("startdate","01/05/2017");
        values.put("enddate","10/05/2017");
    }

    @Test
    public void testGetBookingDetails() throws Exception
    {
        BookCar bk = BookCarFactory.getBookingDetails(values,"bk001");
        assertEquals("bk001",bk.getBookRef());

    }

}