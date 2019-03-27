/**
 * Written by Kyle Truong
 */

package csuebswe.salesforcelite.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class CustomerModel implements Serializable, User {
    // Member fields
    private Map<Integer, Sale> openSales;
    private Map<Integer, Sale> closedSales;
    private Logger logger;
    private String username, password;
    //Menu menu;

    // Constructor
    public CustomerModel(String usr, String pw, Logger log) {
        openSales = new LinkedHashMap<>();
        closedSales = new LinkedHashMap<>();
        logger = log;
        username = usr;
        password = pw;

        // TODO: Create the menu for customer
    }

//    public void executeMenuItemAt(Context callingContext, int index) {
//        menu.getMenuItem(index).execute(callingContext);
//    }

    // Retrieve a new sale offer created by an employee
    public void retrieveNewSale(Sale sale) {
        openSales.put(sale.getId(), sale);
    }

    // Moves a sale from open to closed
    // Notify the logger that the sale has been closed
    public void closeSale(int sale_id, boolean decision) {
        Sale closedSale = openSales.remove(sale_id);
        closedSale.setSaleDecision(decision);
        closedSales.put(closedSale.getId(), closedSale);
        logger.acceptClosedSale(closedSale.getId());
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}