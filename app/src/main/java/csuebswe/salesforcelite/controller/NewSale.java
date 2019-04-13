package csuebswe.salesforcelite.controller;

import android.content.Context;
import android.content.Intent;

import java.io.Serializable;

import csuebswe.salesforcelite.CustomerListActivity;
import csuebswe.salesforcelite.model.EmployeeModel;

public class NewSale implements MenuItem, Serializable {
    EmployeeModel employee;
    String name;

    public NewSale(String _name, EmployeeModel _employee) {
        name = _name;
        employee = _employee;
    }


    public String toString() {
        return name;

    }
    @Override
    public void execute(Context callingContext) {
        Intent intent = new Intent(callingContext, CustomerListActivity.class);
        intent.putExtra("Customers", employee);
        callingContext.startActivity(intent);
    }
}
