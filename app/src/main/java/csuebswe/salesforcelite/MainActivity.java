package csuebswe.salesforcelite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import csuebswe.salesforcelite.controller.CloseSale;
import csuebswe.salesforcelite.controller.MainMenu;
import csuebswe.salesforcelite.controller.SaleList;
import csuebswe.salesforcelite.model.AllCustomers;
import csuebswe.salesforcelite.model.AllEmployees;
import csuebswe.salesforcelite.model.CustomerModel;
import csuebswe.salesforcelite.model.EmployeeModel;
import csuebswe.salesforcelite.model.Logger;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button login;
    AllEmployees employees;
    AllCustomers customers;
    Logger log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        employees = new AllEmployees();
        customers = new AllCustomers();
        log = new Logger();

        // TODO: hardcode employees, customers, and any other data here
        employees.addEmployee("kyle", "123", log, customers);
        customers.addCustomer("yang", "123", log);
        employees.getEmployee("kyle").offerNewSale("yang", "paper");
        employees.getEmployee("kyle").offerNewSale("yang", "pencils");
        employees.getEmployee("kyle").offerNewSale("yang", "staples");

        // TODO: implement a 'create account' page

        // Login field
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usr = username.getText().toString();
                String pw = password.getText().toString();

                // Go to employee activity
                if (employees.contains(usr)) {
                    if (employees.getEmployeePassword(usr).equals(pw)) {
                        Toast.makeText(MainActivity.this,"Successful login",Toast.LENGTH_LONG).show();

                        // Lots of stuff happening here, creating menu
                        EmployeeModel employee = employees.getEmployee(usr);
                        MainMenu employeeMainMenu = new MainMenu(employee);
                        employeeMainMenu.addMenuItem(new SaleList("Open Sales", employee.getOpenSales()));
                        employeeMainMenu.addMenuItem(new SaleList("Closed Sales", employee.getClosedSales()));

                        // Pass menu (controller) to next activity (view)
                        Intent intent = new Intent(MainActivity.this, EmployeeActivity.class);
                        intent.putExtra("employee_menu", employeeMainMenu);
                        startActivity(intent);
                    }
                }

                // Go to customer activity
                else if (customers.contains(usr)) {
                    if (customers.getCustomerPassword(usr).equals(pw)) {
                        Toast.makeText(MainActivity.this,"Successful login",Toast.LENGTH_LONG).show();

                        CustomerModel customer = customers.getCustomer(usr);
                        MainMenu customerMainMenu = new MainMenu(customer);
                        customerMainMenu.addMenuItem(new SaleList("Open Sales", customer.getOpenSales()));
                        customerMainMenu.addMenuItem(new SaleList("Closed Sales", customer.getClosedSales()));
                        customerMainMenu.addMenuItem(new CloseSale("Accept/Decline Sale", customer.getOpenSales()));

                        Intent intent = new Intent(MainActivity.this, CustomerActivity.class);
                        intent.putExtra("customer_menu", customerMainMenu);
                        startActivity(intent);
                    }
                }

                // Login failed
                else
                    Toast.makeText(MainActivity.this,"Authentication Failed",Toast.LENGTH_LONG).show();
            }
        });
    }
}