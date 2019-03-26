package csuebswe.salesforcelite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import csuebswe.salesforcelite.models.EmployeeModel;

public class EmployeeActivity extends AppCompatActivity implements EmployeeViewAdapter.ItemClickListener {
    EmployeeViewAdapter adapter;
    EmployeeModel employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        employee = (EmployeeModel)getIntent().getSerializableExtra("employee_activity");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvEmployee);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EmployeeViewAdapter(this, employee);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        if (position == 0) {
//            Intent intent = new Intent(this, OpenSalesView.class);
//            intent.putExtra("OpenSales", employee);
//            startActivity(intent);
        }

        else if (position == 1) {
//            Intent intent = new Intent(this, ClosedSalesView.class);
//            intent.putExtra("ClosedSales", employee);
//            startActivity(intent);
        }

        else if (position == 2) {
//            Intent intent = new Intent(this, NewSaleView.class);
//            intent.putExtra("NewSale", employee);
//            startActivity(intent);
        }
    }
}

