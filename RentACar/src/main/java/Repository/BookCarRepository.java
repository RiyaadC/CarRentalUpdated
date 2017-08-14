package Repository;

import Domain.BookCar;

/**
 * Created by Riyaad on 8/13/2017.
 */
public interface BookCarRepository
{

    BookCar create(BookCar booking);
    BookCar read(String id);
    BookCar update(BookCar bookDetails);
    void delete(String id);
}
