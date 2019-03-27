package csuebswe.salesforcelite.model;

import java.io.Serializable;

// TODO: create name attribute and override toString() to display the name
// TODO: fix how sales are represented in SaleListViewAdapter bc rn it just shows the id
// TODO: also gotta fix when Sale is created in EmployeeModel

/**
 * Represents a sale created by an employee and given to a customer
 * This object contains all the necessary information associated with a sale
 */
public class Sale implements Serializable
{
    // Member fields
    private EmployeeModel employee;
    private CustomerModel customer;
    private int id;
    private boolean rating;
    private boolean saleDecision;
    private String name;

    // Constructor
    public Sale(EmployeeModel em, CustomerModel cm, int sale_id, String name) {
        employee = em;
        customer = cm;
        id = sale_id;
        this.name = name;
    }

    // Setters
    public void setSaleDecision(boolean decision) {
        saleDecision = decision;
    }

    public void setEmployee(EmployeeModel em) {
        employee = em;
    }

    public void setName(String n) {
        name = n;
    }

    // Getters
    public int getId() {
        return id;
    }

    public EmployeeModel getEmployee() {
        return employee;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public String getName() {
        return name;
    }
}