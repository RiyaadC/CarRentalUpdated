package Repository.Impl;

import Domain.BookCar;
import Repository.BookCarRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class BookCarRepositoryImpl implements BookCarRepository
{
    private static BookCarRepositoryImpl respository = null;

    private Map<String, BookCar> BookCarTable;

    private BookCarRepositoryImpl()
    {
        BookCarTable = new HashMap<String, BookCar>();
    }

    public static BookCarRepositoryImpl getInstance() {
        if (respository == null)
            respository = new BookCarRepositoryImpl();
        return respository;
    }

    public BookCar create(BookCar createBookCar) {
        BookCarTable.put(createBookCar.getBookRef(), createBookCar);
        BookCar savedBookCar = BookCarTable.get(createBookCar.getBookRef());
        return savedBookCar;
    }

    public BookCar read(String id) {
        BookCar BookCar1 = BookCarTable.get(id);
        return BookCar1;
    }

    public BookCar update(BookCar updateBookCar) {
        BookCarTable.put(updateBookCar.getBookRef(), updateBookCar);
        BookCar savedBookCar = BookCarTable.get(updateBookCar.getBookRef());
        return savedBookCar;
    }

    public void delete(String id)
    {
        BookCarTable.remove(id);


    }
}
