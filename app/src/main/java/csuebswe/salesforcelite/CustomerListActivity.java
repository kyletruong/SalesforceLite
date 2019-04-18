package csuebswe.salesforcelite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import csuebswe.salesforcelite.model.CustomerModel;
import csuebswe.salesforcelite.model.EmployeeModel;

public class CustomerListActivity extends AppCompatActivity implements CustomerListAdapter.ItemClickListener {

    EmployeeModel employee;
    CustomerListAdapter adapter;
    List<CustomerModel> customers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customers_list);

        employee = (EmployeeModel) getIntent().getSerializableExtra("Customers");
        customers = new ArrayList<>(employee.getCustomers().getAllCustomers().values());
        RecyclerView recyclerView = findViewById(R.id.customerList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomerListAdapter(this, employee);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
            String custUsername = customers.get(position).getUsername();
            Intent intent = new Intent(this, NewSaleView.class);
            intent.putExtra("employeeName", employee);
            intent.putExtra("customerName", custUsername);
            startActivity(intent);
    }
}
