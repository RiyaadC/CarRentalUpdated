package Repository.Impl;

import Domain.Customer;
import Repository.CustomerRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class CustomerRepositoryImpl implements CustomerRepository
{
    private static CustomerRepositoryImpl respository = null;

    private Map<String, Customer> CustomerTable;

    private CustomerRepositoryImpl()
    {
        CustomerTable = new HashMap<String, Customer>();
    }

    public static CustomerRepositoryImpl getInstance() {
        if (respository == null)
            respository = new CustomerRepositoryImpl();
        return respository;
    }

    public Customer create(Customer createCustomer) {
        CustomerTable.put(createCustomer.getCustID(), createCustomer);
        Customer savedCustomer = CustomerTable.get(createCustomer.getCustID());
        return savedCustomer;
    }

    public Customer read(String id) {
        Customer Customer1 = CustomerTable.get(id);
        return Customer1;
    }

    public Customer update(Customer updateCustomer) {
        CustomerTable.put(updateCustomer.getCustID(), updateCustomer);
        Customer savedCustomer = CustomerTable.get(updateCustomer.getCustID());
        return savedCustomer;
    }

    public void delete(String id)
    {
        CustomerTable.remove(id);


    }

}
