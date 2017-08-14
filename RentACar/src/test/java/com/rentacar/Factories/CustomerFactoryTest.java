package com.rentacar.Factories;

import Domain.Customer;
import Factories.CustomerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class CustomerFactoryTest
{
    Map<String,String> values;
    @BeforeMethod
    public void setUp() throws Exception
    {
        values = new HashMap<String, String>();
        values.put("custID","CUST940113");
        values.put("custName","Riyaad");
        values.put("custLastName","Cader");
        values.put("custEmail","abc@gmail.com");
    }

    @Test
    public void testGetCustomer() throws Exception
    {
        Customer cust = CustomerFactory.getCustomer(values,"CUST940113");
        assertEquals("Cader",cust.getCustLastName());
    }

}