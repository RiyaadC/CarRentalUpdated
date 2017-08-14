package Factories;

import Domain.BookCar;

import java.util.Map;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class BookCarFactory
{
    public static BookCar getBookingDetails(Map<String, String> values,String bref)
    {
        BookCar book = new BookCar.Builder()
                .bookRef(bref)
                .startDate(values.get("startdate"))
                .endDate(values.get("endDate"))
                .build();

        return book;
    }
}
