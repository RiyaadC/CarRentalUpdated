package com.rentacar.Repository;

import Domain.BookCar;
import Factories.BookCarFactory;
import Repository.BookCarRepository;
import Repository.Impl.BookCarRepositoryImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * Created by Riyaad on 8/14/2017.
 */
public class BookCarRepositoryTest
{
    BookCarRepository repository;
    Map<String,String> values;
    @BeforeMethod
    public void setUp() throws Exception
    {
        repository = BookCarRepositoryImpl.getInstance();
        values = new HashMap<String, String>();
        values.put("BookRef","BK001");
        values.put("startdate","01/02/2017");
        values.put("enddate","05/02/2017");
    }

    @Test
    public void Create() throws Exception
    {
        BookCar book = BookCarFactory.getBookingDetails(values,"BK001");
        repository.create(book);
        assertEquals("BK001",book.getBookRef());
    }

    @Test(dependsOnMethods = "Create")
    public void Read() throws Exception
    {
        BookCar readbooking = repository.read("BK001");
        assertEquals("BK001",readbooking.getBookRef());
    }

    @Test(dependsOnMethods = "Read")
    public void Update() throws Exception
    {
        BookCar bk = repository.read("BK002");
        BookCar bk1 = new BookCar.Builder()
                .bookRef("BK002")
                .startDate("01/02/2017")
                .endDate("05/02/2017")
                .build();
        repository.update(bk1);
        BookCar UpdateBooking = repository.read("BK001");
        assertEquals("BK001",UpdateBooking.getBookRef());
    }

    @Test(dependsOnMethods = "Update")
    public void Delete() throws Exception
    {
        repository.delete("BK001");
        BookCar bk = repository.read("BK001");
        assertNull(bk);
    }

}