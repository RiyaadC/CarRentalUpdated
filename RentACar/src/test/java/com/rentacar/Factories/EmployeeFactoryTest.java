package com.rentacar.Factories;

import Domain.Employee;
import Factories.EmployeeFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class EmployeeFactoryTest {

    Map<String,String> values;
    @BeforeMethod
    public void setUp() throws Exception
    {

        values = new HashMap<String, String>();
        values.put("empID","EMP940113");
        values.put("empName","Riyaad");
        values.put("empLastName","Cader");
        values.put("empEmail","abc@gmail.com");
    }

    @Test
    public void testGetEmployee() throws Exception
    {
        Employee emp = EmployeeFactory.getEmployee(values,"EMP940113");
        assertEquals("Cader",emp.getempLastName());
    }

}