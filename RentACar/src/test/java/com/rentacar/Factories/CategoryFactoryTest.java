package com.rentacar.Factories;

import Domain.Category;
import Factories.CategoryFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class CategoryFactoryTest {
    Map<String,String> values;
    @BeforeMethod
    public void setUp() throws Exception
    {
        values = new HashMap<String, String>();
        values.put("catType","Lux");
        values.put("rentalRate","200");

    }

    @Test
    public void testGetCategories() throws Exception
    {
        Category cat1 = CategoryFactory.getCategories(values,"CAT001");
        assertEquals("CAT001",cat1.getCatID());
    }

}