package com.corporate.employee.constants;

public enum EmployeeEnum {

    IT("IT"),
    HR("HR"),
    CustomerService("CustomerService");

    private final String department;

    EmployeeEnum(String department){
        this.department = department;
    }
}
