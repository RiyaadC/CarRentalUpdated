package Services.Impl;

import Domain.Customer;
import Repository.CustomerRepository;
import Repository.Impl.CustomerRepositoryImpl;
import Services.CustomerService;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class CustomerServiceImpl implements CustomerService
{
    private static CustomerServiceImpl service = null;

    CustomerRepository repository = CustomerRepositoryImpl.getInstance();

    public static CustomerServiceImpl getInstance(){
        if(service == null)
            service = new CustomerServiceImpl();
        return service;
    }

    public Customer create(Customer createCustomer) {
        return repository.create(createCustomer);
    }

    public Customer read(String id)
    {
        return repository.read(id);
    }

    public Customer update(Customer updateCustomer) {
        return repository.update(updateCustomer);
    }

    public void delete(String id)
    {
        repository.delete(id);

    }


}
