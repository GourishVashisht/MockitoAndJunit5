package com.nagarro.employeemanaement;

public class EmployeeRepository implements IEmployeeRepository {

    @Override
    public Employee getEmployee() {
        return new Employee("1", "NAGP");
    }

    @Override
    public Employee createEmployee(final Employee employee) {
        if (employee == null) {
            throw new InvalidRequestException("Employee must not be null");
        }
        System.out.println("Employee saved");
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {

    }
}
