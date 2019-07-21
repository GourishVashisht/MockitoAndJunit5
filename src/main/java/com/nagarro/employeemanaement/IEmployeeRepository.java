package com.nagarro.employeemanaement;

public interface IEmployeeRepository {

    Employee getEmployee();

    Employee createEmployee(Employee employee);

    void addEmployee(Employee employee);

}