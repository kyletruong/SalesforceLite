package csuebswe.salesforcelite.model;

import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.*;

/**
 *
 * @author alannoun
 */
public class EmployeeModelTest {
    EmployeeModel employee;
    Logger log;
    private AllCustomers customers;

    @Before
    public void setUp() {
        log = new Logger();
        customers = new AllCustomers();
        customers.addCustomer("cust1", "custpw", log);
        employee = new EmployeeModel("1234", "1234", log, customers);
    }

    @Test
    public void openNewSale(){ //This file creates a new sale then checks to see if the new sale object is actually inside open sales map.
        employee.offerNewSale("cust1", "bread");
        Map<Integer, Sale> openSales;

        openSales = employee.getOpenSales();
        for (Sale _sale : openSales.values())
            assertEquals(_sale.getName(), "bread");

    }

    @Test
    public void closeSale(){ //This function closes the new sale and puts it inside the closed sale map.
        employee.offerNewSale("cust1", "bread");
        Map<Integer, Sale> openSales;
        openSales = employee.getOpenSales();
        Sale saleToBeClosed = null;
        for (Sale _sale : openSales.values())
            saleToBeClosed = _sale;

        employee.closeSale(saleToBeClosed.getId());

        for (Sale _sale : employee.getClosedSales().values())
            assertEquals(_sale.getName(), "bread");

    }
}