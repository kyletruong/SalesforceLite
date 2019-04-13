package csuebswe.salesforcelite.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllCustomers implements Serializable {
    private Map<String, CustomerModel> customers;

    public AllCustomers() {
        customers = new HashMap<>();
    }

    public boolean addCustomer(String usr, String pw, Logger log) {
        if (customers.containsKey(usr))
            return false;

        CustomerModel newCustomer = new CustomerModel(usr, pw, log);
        customers.put(usr, newCustomer);
        return true;
    }

    public boolean contains(String usr) {
        return customers.containsKey(usr);
    }

    public CustomerModel getCustomer(String usr) {
        return customers.get(usr);
    }



    public String getCustomerPassword(String usr) {
        return customers.get(usr).getPassword();
    }

    public Map getAllCustomers() { return customers; }
}
