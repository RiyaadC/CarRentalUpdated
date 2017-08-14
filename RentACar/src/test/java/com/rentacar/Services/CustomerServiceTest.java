package com.rentacar.Services;

import Domain.Customer;
import Factories.CustomerFactory;
import Services.CustomerService;
import Services.Impl.CustomerServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class CustomerServiceTest 
{
    CustomerService service;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception
    {
        service = CustomerServiceImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("custID","CUST940113");
        values.put("custName","Riyaad");
        values.put("custLastName","Cader");
        values.put("custEmail","abc@gmail.com");
    }

    @Test
    public void Create() throws Exception
    {
        Customer cust1 = CustomerFactory.getCustomer(values,"CUST940113");
        service.create(cust1);
        assertEquals("CUST940113",cust1.getCustID());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception
    {
        Customer readcustomer = service.read("CUST940113");
        assertEquals("abc@gmail.com",readcustomer.getCustEmail());
    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception
    {
        Customer cust1 = service.read("CUST940113");
        Customer cust = new Customer.Builder()
                .custID("CUST940113")
                .custEmail("def@gmail.com")
                .custName("Riyaad")
                .custLastName("Cader")
                .build();
        service.update(cust);
        Customer UpdateCustomer = service.read("CUST940113");
        assertEquals("def@gmail.com",UpdateCustomer.getCustEmail());
    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception
    {
        service.delete("CUST940113");
        Customer cust1 = service.read("940113");
        assertNull(cust1);
    }

}