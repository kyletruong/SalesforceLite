package csuebswe.salesforcelite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import csuebswe.salesforcelite.models.AllCustomers;
import csuebswe.salesforcelite.models.AllEmployees;
import csuebswe.salesforcelite.models.EmployeeModel;
import csuebswe.salesforcelite.models.Logger;

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

        // TODO: hardcode some employees and customers here
        employees.addEmployee("kyle", "123", log, customers);


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
                        EmployeeModel employee = employees.getEmployee(usr);
                        Intent intent = new Intent(MainActivity.this, EmployeeActivity.class);
                        intent.putExtra("employee_activity", employee);
                        startActivity(intent);
                    }
                }

                // Go to customer activity
                else if (customers.contains(usr)) {
                    if (customers.getCustomerPassword(usr).equals(pw)) {
                        Toast.makeText(MainActivity.this,"Successful login",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, CustomerActivity.class);
                        intent.putExtra("customer_activity", customers.getCustomer(usr));
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