package csuebswe.salesforcelite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import csuebswe.salesforcelite.controller.MainMenu;

public class CustomerActivity extends AppCompatActivity implements MainMenuViewAdapter.ItemClickListener {
    MainMenuViewAdapter adapter;
    MainMenu customerMainMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        customerMainMenu = (MainMenu)getIntent().getSerializableExtra("customer_menu");

        RecyclerView recyclerView = findViewById(R.id.rvCustomer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainMenuViewAdapter(this, customerMainMenu);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    public void onItemClick(View view, int position) {
        customerMainMenu.executeMenuItemAt(this,position);

    }
}
