package com.nagarro.employeemanaement;

import static org.mockito.Mockito.when;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeHandlerAnnotationsTest {

    @Mock
    EmployeeRepository repo;

    @Mock
    Employee employee;

    @InjectMocks
    EmployeeHandler handler;

    @Test
    public void shoulCreateEmployee() {
        // setup1
        when(repo.createEmployee(employee)).thenReturn(employee);

        // execution1
        Employee actual1 = handler.createEmployee(employee);
        MatcherAssert.assertThat(actual1, Is.is(employee));
    }
}
