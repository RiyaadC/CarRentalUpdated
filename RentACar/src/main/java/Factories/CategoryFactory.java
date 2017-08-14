package Factories;

import Domain.Category;

import java.util.Map;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class CategoryFactory
{
    public static Category getCategories(Map<String, String> values,String catID) {
        Category cat1 = new Category.Builder()
                .catID(catID)
                .catType(values.get("catType"))
                .RentalRate(values.get("rentalRate"))
                .build();


        return cat1;
    }
}
