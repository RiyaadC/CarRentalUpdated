package Services;

import Domain.Category;

/**
 * Created by Riyaad on 8/13/2017.
 */
public interface CategoryService
{
    Category create(Category cat1);
    Category read(String id);
}
