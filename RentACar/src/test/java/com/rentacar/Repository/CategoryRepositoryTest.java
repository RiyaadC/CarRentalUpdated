package com.rentacar.Repository;

import Domain.Category;
import Factories.CategoryFactory;
import Repository.CategoryRepository;
import Repository.Impl.CategoryRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class CategoryRepositoryTest {
    CategoryRepository repository;
    Map<String,String> values;
    @BeforeMethod
    public void setUp() throws Exception
    {
        repository = CategoryRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("catID","CAT001");
        values.put("catType","Standard");
        values.put("rentalRate","200");
    }
    @Test
    public void Create() throws Exception
    {
        Category cat1 = CategoryFactory.getCategories(values,"CAT001");
        repository.create(cat1);
        assertEquals("CAT001",cat1.getCatID());
    }

    @Test(dependsOnMethods = "Create")
    public void testRead() throws Exception
    {
        Category readCategory = repository.read("CAT001");
        assertEquals("Standard",readCategory.getCatType());
    }

}