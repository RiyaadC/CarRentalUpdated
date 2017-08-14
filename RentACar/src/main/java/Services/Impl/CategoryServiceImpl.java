package Services.Impl;

import Domain.Category;
import Repository.CategoryRepository;
import Repository.Impl.CategoryRepositoryImpl;
import Services.CategoryService;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class CategoryServiceImpl implements CategoryService
{
    private static CategoryServiceImpl service = null;

    CategoryRepository repository = CategoryRepositoryImpl.getInstance();

    public static CategoryServiceImpl getInstance(){
        if(service == null)
            service = new CategoryServiceImpl();
        return service;
    }

    public Category create(Category createCategory) {
        return repository.create(createCategory);
    }

    public Category read(String id)
    {
        return repository.read(id);
    }



}
