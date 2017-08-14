package com.rentacar.Services;

import Domain.Employee;
import Factories.EmployeeFactory;
import Services.EmployeeService;
import Services.Impl.EmployeeServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class EmployeeServiceTest 
{
    EmployeeService service;
    Map<String,String> values;

    @BeforeMethod
    public void setUp() throws Exception
    {

        service = EmployeeServiceImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("empID","EMP940114");
        values.put("empName","Riyaad");
        values.put("empLastName","Cader");
        values.put("empEmail","abc@gmail.com");
    }

    @Test
    public void Create() throws Exception
    {
        Employee emp1 = EmployeeFactory.getEmployee(values,"EMP940113");
        service.create(emp1);
        //System.out.println(emp1.getempID());
        assertEquals("EMP940113",emp1.getempID());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception
    {
        Employee reademployee = service.read("EMP940114");
        assertEquals("abc@gmail.com",reademployee.getempID());
    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception
    {
        Employee emp1 = service.read("EMP940114");
        Employee emp = new Employee.Builder()
                .empID("EMP940114")
                .empEmail("def@gmail.com")
                .empName("Riyaad")
                .empLastName("Cader")
                .build();
        service.update(emp);
        Employee UpdateCustomer = service.read("EMP940114");
        assertEquals("def@gmail.com",UpdateCustomer.getempEmail());
    }

    @Test
    public void Delete() throws Exception
    {
        service.delete("EMP940113");
        Employee emp1 = service.read("EMP940113");
        assertNull(emp1);
    }
}