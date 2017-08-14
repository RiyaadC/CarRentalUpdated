package Services.Impl;

import Domain.BookCar;
import Repository.BookCarRepository;
import Repository.Impl.BookCarRepositoryImpl;
import Services.BookCarService;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class BookCarServiceImpl implements BookCarService
{
    private static BookCarServiceImpl service = null;

    BookCarRepository repository = BookCarRepositoryImpl.getInstance();

    public static BookCarServiceImpl getInstance(){
        if(service == null)
            service = new BookCarServiceImpl();
        return service;
    }

    public BookCar create(BookCar createBookCar) {
        return repository.create(createBookCar);
    }

    public BookCar read(String id)
    {
        return repository.read(id);
    }

    public BookCar update(BookCar updateBookCar) {
        return repository.update(updateBookCar);
    }

    public void delete(String id)
    {
        repository.delete(id);

    }
}
