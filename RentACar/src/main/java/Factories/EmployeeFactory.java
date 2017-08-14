package Factories;

import Domain.Employee;

import java.util.Map;

/**
 * Created by Riyaad on 8/13/2017.
 */
public class EmployeeFactory
{
    public static Employee getEmployee(Map<String, String> values,String empID)
    {
        Employee emp1 = new Employee.Builder()
                .empID(empID)
                .empName(values.get(("empName")))
                .empLastName(values.get("empLastName"))
                .empEmail(values.get("empEmail"))
                .build();
        return emp1;
    }

}
