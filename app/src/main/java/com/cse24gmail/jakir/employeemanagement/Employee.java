package com.cse24gmail.jakir.employeemanagement;

/**
 * Created by HP on 6/18/2016.
 */
public class Employee {

    int id;
    String name;
    String designation;
    String email;
    String phone;
    String address;

    public Employee(int id, String name, String designation, String email, String phone, String address) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
