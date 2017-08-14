package Services;

import Domain.Employee;

/**
 * Created by Riyaad on 8/13/2017.
 */
public interface EmployeeService
{
    Employee create(Employee emp1);
    Employee read(String id);
    Employee update(Employee empDetails);
    void delete(String id);

}
