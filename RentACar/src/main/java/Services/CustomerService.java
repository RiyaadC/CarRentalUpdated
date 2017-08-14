package Services;

import Domain.Customer;

/**
 * Created by Riyaad on 8/13/2017.
 */
public interface CustomerService
{
    Customer create(Customer cust1);
    Customer read(String id);
    Customer update(Customer carDetails);
    void delete(String id);
}
