package com.rentacar.Repository;

import Domain.Employee;
import Factories.EmployeeFactory;
import Repository.EmployeeRepository;
import Repository.Impl.EmployeeRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class EmployeeRepositoryTest
{
    EmployeeRepository repository;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception
    {

        repository = EmployeeRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("empID","EMP940113");
        values.put("empName","Riyaad");
        values.put("empLastName","Cader");
        values.put("empEmail","abc@gmail.com");
    }

    @Test
    public void Create() throws Exception
    {
        Employee emp1 = EmployeeFactory.getEmployee(values,"EMP940113");
        repository.create(emp1);
        //System.out.println(emp1.getempID());
        assertEquals("EMP940113",emp1.getempID());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception
    {
        Employee reademployee = repository.read("EMP940113");
        assertEquals("abc@gmail.com",reademployee.getempEmail());
    }

   @Test(dependsOnMethods = "Read")
    public void Update() throws Exception
    {
        Employee emp1 = repository.read("EMP940113");
        Employee emp = new Employee.Builder()
                .empID("EMP940113")
                .empEmail("def@gmail.com")
                .empName("Riyaad")
                .empLastName("Cader")
                .build();
        repository.update(emp);
        Employee UpdateCustomer = repository.read("EMP940113");
        assertEquals("def@gmail.com",UpdateCustomer.getempEmail());
    }

    @Test
    public void Delete() throws Exception
    {
        repository.delete("EMP940113");
        Employee emp1 = repository.read("EMP940113");
        assertNull(emp1);
    }

}