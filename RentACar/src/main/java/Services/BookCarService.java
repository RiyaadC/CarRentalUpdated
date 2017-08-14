package Services;

import Domain.BookCar;

/**
 * Created by Riyaad on 8/13/2017.
 */
public interface BookCarService
{
    BookCar create(Domain.BookCar booking);
    BookCar read(String id);
    BookCar update(BookCar bookDetails);
    void delete(String id);

}
