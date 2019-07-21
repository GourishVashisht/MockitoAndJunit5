package com.nagarro.employeemanaement;

public class EmployeeHandler {

    // shared variables
    private IEmployeeRepository repository;
    private static Employee updatedEmployee;

    public EmployeeHandler(IEmployeeRepository employeeRepository) {
        this.repository = employeeRepository;
    }

    public Employee getEmployee() {
        return repository.getEmployee();
    }

    public Employee createEmployee(final Employee employee) {
        final Employee savedEmployee = repository.createEmployee(employee);
        return savedEmployee;
    }

    public void updateEmployee(final Employee employee) {
        updatedEmployee = employee;
    }

    public void addEmployee(Employee employee) {
        repository.addEmployee(employee);
    }

}
