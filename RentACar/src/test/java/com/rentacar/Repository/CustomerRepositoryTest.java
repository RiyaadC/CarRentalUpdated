package com.rentacar.Repository;

import Domain.Customer;
import Factories.CustomerFactory;
import Repository.CustomerRepository;
import Repository.Impl.CustomerRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class CustomerRepositoryTest {
    CustomerRepository repository;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception
    {
        repository = CustomerRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("custID","CUST940114");
        values.put("custName","Riyaad");
        values.put("custLastName","Cader");
        values.put("custEmail","abc@gmail.com");
    }

    @Test
    public void Create() throws Exception
    {
        Customer cust1 = CustomerFactory.getCustomer(values,"CUST940113");
        repository.create(cust1);
        assertEquals("CUST940113",cust1.getCustID());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception
    {
        Customer readcustomer = repository.read("CUST940114");
        assertEquals("abc@gmail.com",readcustomer.getCustEmail());
    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception
    {
        Customer cust1 = repository.read("CUST940114");
        Customer cust = new Customer.Builder()
                .custID("CUST940114")
                .custEmail("def@gmail.com")
                .custName("Riyaad")
                .custLastName("Cader")
                .build();
        repository.update(cust);
        Customer UpdateCustomer = repository.read("CUST940114");
        assertEquals("def@gmail.com",UpdateCustomer.getCustEmail());
    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception
    {
        repository.delete("CUST940113");
        Customer cust1 = repository.read("940113");
        assertNull(cust1);
    }

}