package csuebswe.salesforcelite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.Map;

import csuebswe.salesforcelite.model.EmployeeModel;
import csuebswe.salesforcelite.model.Sale;

public class NewSaleView extends AppCompatActivity {
    private Button newSale;
    private EditText task;
    private EmployeeModel employee;
    private String customer;
    Map<Integer, Sale> openSales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsale);


        newSale = findViewById(R.id.addSale);
        task = findViewById(R.id.newTask);



        employee = (EmployeeModel)getIntent().getSerializableExtra("employeeName");
        customer = (String)getIntent().getSerializableExtra("customerName");
        openSales = employee.getOpenSales();
        newSale = findViewById(R.id.addSale);
        newSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employee.offerNewSale(customer, task.getText().toString());
                Toast.makeText(NewSaleView.this,"Successful Task Added",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(NewSaleView.this, SaleListActivity.class);
                intent.putExtra("salelist", (Serializable)openSales);
                startActivity(intent);
            }
        });


    }


}
