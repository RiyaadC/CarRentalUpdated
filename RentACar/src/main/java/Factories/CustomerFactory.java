package Factories;

import Domain.Customer;

import java.util.Map;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class CustomerFactory
{
    public static Customer getCustomer(Map<String, String> values,String custID) {
        Customer cust1 = new Customer.Builder()
                .custID(custID)
                .custName(values.get("custName"))
                .custLastName(values.get("custLastName"))
                .custEmail(values.get("custEmail"))
                .build();
        return cust1;
    }
}
