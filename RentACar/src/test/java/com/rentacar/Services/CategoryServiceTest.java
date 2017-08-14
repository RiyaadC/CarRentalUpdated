package com.rentacar.Services;

import Domain.Category;
import Factories.CategoryFactory;
import Services.CategoryService;
import Services.Impl.CategoryServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class CategoryServiceTest 
{
    CategoryService service;
    Map<String,String> values;
    @BeforeMethod
    public void setUp() throws Exception
    {
        service = CategoryServiceImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("catID","CAT001");
        values.put("catType","Standard");
        values.put("rentalRate","200");
    }
    @Test
    public void Create() throws Exception
    {
        Category cat1 = CategoryFactory.getCategories(values,"CAT001");
        service.create(cat1);
        assertEquals("CAT001",cat1.getCatID());
    }

    @Test(dependsOnMethods = "Create")
    public void testRead() throws Exception
    {
        Category readCategory = service.read("CAT001");
        assertEquals("Standard",readCategory.getCatType());
    }

}