package csuebswe.salesforcelite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import csuebswe.salesforcelite.controller.MainMenu;

public class EmployeeActivity extends AppCompatActivity implements MainMenuViewAdapter.ItemClickListener {
    MainMenuViewAdapter adapter;
    MainMenu employeeMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);
        employeeMainMenu = (MainMenu)getIntent().getSerializableExtra("employee_menu");

        // TODO: delete. Rather pass the menu. I don't like passing a model to a view
        // employee = (EmployeeModel)getIntent().getSerializableExtra("employee_activity");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvEmployee);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainMenuViewAdapter(this, employeeMainMenu);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        employeeMainMenu.executeMenuItemAt(this, position);

//        if (position == 0) {
//            Intent intent = new Intent(this, OpenSalesView.class);
//            intent.putExtra("OpenSales", employee);
//            startActivity(intent);
//        }
//
//        else if (position == 1) {
//            Intent intent = new Intent(this, ClosedSalesView.class);
//            intent.putExtra("ClosedSales", employee);
//            startActivity(intent);
//        }
//
//        else if (position == 2) {
//            Intent intent = new Intent(this, NewSaleView.class);
//            intent.putExtra("NewSale", employee);
//            startActivity(intent);
//        }
    }
}

