package com.nagarro.employeemanaement;

public class Employee {

    private final String id;
    private final String name;

    public Employee(final String id, final String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
