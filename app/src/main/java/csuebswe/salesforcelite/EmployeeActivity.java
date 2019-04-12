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
    }
}

