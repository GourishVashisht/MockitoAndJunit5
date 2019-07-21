package com.nagarro.employeemanaement;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class EmployeeHandlerMockTest {
    IEmployeeRepository repo;
    EmployeeHandler handler;

    @Before
    public void setup() {
        repo = Mockito.mock(IEmployeeRepository.class);
        handler = new EmployeeHandler(repo);
    }

    // @Test
    // public void shouldCreateEmployee() {
    // Employee employee = new Employee("1", "NAGP");
    // Employee actualEmployee = handler.createEmployee(employee);
    // assertSame(employee, actualEmployee);
    // assertEquals(employee.getId(), actualEmployee.getId());
    // assertEquals(employee.getName(), actualEmployee.getName());
    // }

    @Test
    public void shouldCreateEmployeeAgainWithTwoSetups() {
        // setup1
        Employee employee = new Employee("1", "sk");
        when(repo.createEmployee(employee)).thenReturn(employee);

        // execution1
        Employee actual1 = handler.createEmployee(employee);
        MatcherAssert.assertThat(actual1, Is.is(employee));

        // setup2
        Employee expected = Mockito.mock(Employee.class);
        when(repo.createEmployee(expected)).thenReturn(expected);

        // execution2
        Employee actual2 = handler.createEmployee(expected);
        MatcherAssert.assertThat(actual2, Is.is(expected));
    }

    @Test
    public void shouldCreateEmployeeAgainWithAny() {
        // setup
        Employee expected = mock(Employee.class);
        when(repo.createEmployee(Mockito.any(Employee.class))).thenReturn(expected);

        // execution
        Employee actual = handler.createEmployee(expected);
        MatcherAssert.assertThat(actual, Is.is(expected));
    }

    @Test
    public void shoulAddNewEmployee() {
        // setup
        Employee employee = Mockito.mock(Employee.class);

        // execution
        handler.addEmployee(employee);

        // verification
        ArgumentCaptor<Employee> captor = ArgumentCaptor.forClass(Employee.class);
        verify(repo, times(1)).addEmployee(captor.capture());
        verifyNoMoreInteractions(repo);
        MatcherAssert.assertThat(employee, is(captor.getValue()));
        assertEquals(captor.getValue(), employee);
    }

}
