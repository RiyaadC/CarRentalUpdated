package Repository;


import Domain.Category;

/**
 * Created by Riyaad on 8/13/2017.
 */
public interface CategoryRepository
{
    Category create(Category cat1);
    Category read(String id);

}
