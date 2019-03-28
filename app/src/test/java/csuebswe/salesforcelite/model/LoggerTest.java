package csuebswe.salesforcelite.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoggerTest {
    Logger log;
    EmployeeModel employee;
    AllCustomers allCustomers;

    @Before
    public void setUp() throws Exception {
        log = new Logger();
        allCustomers = new AllCustomers();
        allCustomers.addCustomer("bob", "123password", log);
        employee = new EmployeeModel("kyle", "123password", log, allCustomers);
    }

    @Test
    public void acceptNewSale() {
        employee.offerNewSale("bob", "bread");
        assertEquals(1, log.openSales.size());
        assertEquals(0, log.closedSales.size());
    }

    @Test
    public void acceptClosedSale() {
        employee.offerNewSale("bob", "milk");
        CustomerModel customer = allCustomers.getCustomer("bob");
        int sale_id = 0;
        for (int x : log.openSales.keySet())
            sale_id = x;

        customer.closeSale(sale_id, true);
        assertEquals(0, log.openSales.size());
        assertEquals(1, log.closedSales.size());
    }

    @Test
    public void doesSaleIdExist() {
        employee.offerNewSale("bob", "milk");
        CustomerModel customer = allCustomers.getCustomer("bob");
        int sale_id = 0;
        for (int x : log.openSales.keySet())
            sale_id = x;

        assertTrue(log.doesSaleIdExist(sale_id));
    }
}