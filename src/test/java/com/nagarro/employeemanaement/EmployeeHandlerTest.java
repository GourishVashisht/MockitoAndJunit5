package com.nagarro.employeemanaement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

class FakeEmployeeReposotory implements IEmployeeRepository {

    @Override
    public Employee getEmployee() {
        return new Employee("1", "NAGP");
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {

    }
}

public class EmployeeHandlerTest {

    FakeEmployeeReposotory repo;
    EmployeeHandler handler;

    @Before
    public void setup() {
        repo = new FakeEmployeeReposotory();
        handler = new EmployeeHandler(repo);
    }

    @Test
    public void shouldCreateEmployee() {
        Employee employee = new Employee("1", "NAGP");
        Employee actualEmployee = handler.createEmployee(employee);
        assertSame(employee, actualEmployee);
        // assertEquals(employee.getId(), actualEmployee.getId());
        // assertEquals(employee.getName(), actualEmployee.getName());
    }

    @Test
    public void shouldReturnEmployeeFromDatabase() {
        Employee expectedEmployee = new Employee("1", "NAGP");
        Employee employee = handler.getEmployee();
        assertEquals(expectedEmployee.getId(), employee.getId());
        assertEquals(expectedEmployee.getName(), employee.getName());
    }

    @Test
    public void shouldUpdateExistingEmployeeInDatabase() {
        Employee employee = new Employee("1", "NAGP");
        handler.updateEmployee(employee);

    }

}
