package Repository.Impl;

import Domain.Category;
import Repository.CategoryRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class CategoryRepositoryImpl implements CategoryRepository
{

    private static CategoryRepositoryImpl respository = null;

    private Map<String, Category> CategoryTable;

    private CategoryRepositoryImpl()
    {
        CategoryTable = new HashMap<String, Category>();
    }

    public static CategoryRepositoryImpl getInstance()
    {
        if (respository == null)
            respository = new CategoryRepositoryImpl();
        return respository;
    }

    public Category create(Category createCategory) {
        CategoryTable.put(createCategory.getCatID(), createCategory);
        Category savedCategory = CategoryTable.get(createCategory.getCatID());
        return savedCategory;
    }

    public Category read(String id)
    {
        Category Category1 = CategoryTable.get(id);
        return Category1;
    }

    
}
