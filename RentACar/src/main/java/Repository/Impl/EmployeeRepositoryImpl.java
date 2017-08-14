package Repository.Impl;

import Domain.Employee;
import Repository.EmployeeRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class EmployeeRepositoryImpl implements EmployeeRepository
{

    private static EmployeeRepositoryImpl respository = null;

    private Map<String, Employee> EmployeeTable;

    private EmployeeRepositoryImpl()
    {
        EmployeeTable = new HashMap<String, Employee>();
    }

    public static EmployeeRepositoryImpl getInstance() {
        if (respository == null)
            respository = new EmployeeRepositoryImpl();
        return respository;
    }

    public Employee create(Employee createEmployee) {
        EmployeeTable.put(createEmployee.getempID(), createEmployee);
        Employee savedEmployee = EmployeeTable.get(createEmployee.getempID());
        return savedEmployee;
    }

    public Employee read(String id) {
        Employee Employee1 = EmployeeTable.get(id);
        return Employee1;
    }

    public Employee update(Employee updateEmployee) {
        EmployeeTable.put(updateEmployee.getempID(), updateEmployee);
        Employee savedEmployee = EmployeeTable.get(updateEmployee.getempID());
        return savedEmployee;
    }

    public void delete(String id)
    {
        EmployeeTable.remove(id);


    }
}
