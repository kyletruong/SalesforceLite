package csuebswe.salesforcelite.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AllEmployees implements Serializable {
    private Map<String, EmployeeModel> employees;

    public AllEmployees() {
        employees = new HashMap<>();
    }

    public boolean addEmployee(String usr, String pw, Logger log, AllCustomers customers) {
        if (employees.containsKey(usr))
            return false;

        EmployeeModel newEmployee = new EmployeeModel(usr, pw, log, customers);
        employees.put(usr, newEmployee);
        return true;
    }

    public boolean contains(String usr) {
        return employees.containsKey(usr);
    }

    public String getEmployeePassword(String usr) {
        return employees.get(usr).getPassword();
    }

    public EmployeeModel getEmployee(String usr) {
        return employees.get(usr);
    }
}
