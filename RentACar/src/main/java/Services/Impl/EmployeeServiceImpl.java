package Services.Impl;

import Domain.Employee;
import Repository.EmployeeRepository;
import Repository.Impl.EmployeeRepositoryImpl;
import Services.EmployeeService;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class EmployeeServiceImpl implements EmployeeService
{
    private static EmployeeServiceImpl service = null;

    EmployeeRepository repository = EmployeeRepositoryImpl.getInstance();

    public static EmployeeServiceImpl getInstance(){
        if(service == null)
            service = new EmployeeServiceImpl();
        return service;
    }

    public Employee create(Employee createEmployee) {
        return repository.create(createEmployee);
    }

    public Employee read(String id)
    {
        return repository.read(id);
    }

    public Employee update(Employee updateEmployee) {
        return repository.update(updateEmployee);
    }

    public void delete(String id)
    {
        repository.delete(id);

    }

}
