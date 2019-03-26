package csuebswe.salesforcelite.models;

import java.io.Serializable;
import java.util.*;

public class EmployeeModel implements Serializable {
    // Member fields
    public Map<Integer, Sale> openSales;
    public Map<Integer, Sale> closedSales;
    public AllCustomers customers;
    private List<String> options;
    private Logger logger;
    private final int MAX_SALE_ID = 10000;
    private String username, password;

    // Constructor
    public EmployeeModel(String usr, String pw, Logger log, AllCustomers customers) {
        logger = log;
        closedSales = new HashMap<>();
        openSales = new HashMap<>();
        this.customers = customers;
        username = usr;
        password = pw;

        options = new ArrayList<>();
        options.add("Open Sales");
        options.add("Closed Sales");
        options.add("New Sale");
    }

    // Retrieve a customer by their username
    public CustomerModel getCustomer(String username) {
        return customers.getCustomer(username);
    }


    // Create a new sale with a unique id then offer it a specific customer
    public void offerNewSale(String customer_username) {
        Random rand = new Random();
        int n = rand.nextInt(MAX_SALE_ID);

        while (logger.doesSaleIdExist(n))
            n = rand.nextInt(MAX_SALE_ID);

        // Create sale object
        Sale newSale;
        newSale = new Sale(this, getCustomer(customer_username), n);

        openSales.put(n, newSale);
        logger.acceptNewSale(newSale);
    }

    // Move an open sale to a closed sale
    public void closeSale(int sale_id) {
        Sale closedSale = openSales.remove(sale_id);
        closedSales.put(sale_id, closedSale);
    }

    String getPassword() {
        return password;
    }

    public Map<Integer, Sale> getClosedSales() {
        return closedSales;
    }

    public Map<Integer, Sale> getOpenSales() {
        return openSales;
    }

    public List<String> getOptions() {
        return options;
    }
}