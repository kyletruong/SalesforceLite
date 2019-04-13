package csuebswe.salesforcelite.controller;

import android.content.Context;
import android.content.Intent;
import java.io.Serializable;
import java.util.Map;

import csuebswe.salesforcelite.CustomerListActivity;
import csuebswe.salesforcelite.model.CustomerModel;

public class CustomersList implements MenuItem, Serializable {
    Map<Integer, CustomerModel> customers;



    public CustomersList(Map<Integer, CustomerModel> customers) {
        this.customers = customers;
    }

    // **IMPORTANT**
    // the 'saleslist' string is a key for deserialization
    @Override
    public void execute(Context callingContext) {
        Intent intent = new Intent(callingContext, CustomerListActivity.class);
        intent.putExtra("customerList", (Serializable)customers);
        callingContext.startActivity(intent);
    }


}