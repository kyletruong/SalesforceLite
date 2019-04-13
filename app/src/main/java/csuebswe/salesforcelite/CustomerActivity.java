package csuebswe.salesforcelite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.Serializable;

import csuebswe.salesforcelite.controller.MainMenu;
import csuebswe.salesforcelite.model.CustomerModel;

public class CustomerActivity extends AppCompatActivity implements MainMenuViewAdapter.ItemClickListener {
    MainMenuViewAdapter adapter;
    MainMenu customerMainMenu;
    CustomerModel customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        customerMainMenu = (MainMenu)getIntent().getSerializableExtra("customer_menu");
        customer = (CustomerModel) getIntent().getSerializableExtra("customer");

        RecyclerView recyclerView = findViewById(R.id.rvCustomer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainMenuViewAdapter(this, customerMainMenu);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    public void onItemClick(View view, int position) {
        if (position == 0) {
            Intent intent = new Intent(this, SaleListActivity.class);
            intent.putExtra("salelist", (Serializable)customer.getOpenSales());
            startActivity(intent);
        }

        else if (position == 1) {
            Intent intent = new Intent(this, SaleListActivity.class);
            intent.putExtra("salelist", (Serializable)customer.getClosedSales());
            startActivity(intent);
        }

        else if (position == 2) {
            Intent intent = customerMainMenu.getIntent(this, position);
            intent.putExtra("closesale", (Serializable)customer.getOpenSales());
            intent.putExtra("customer", customer);
            startActivityForResult(intent, 0);
        }
    }

    //In your class
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Retrieve data in the intent
        int sale_id = data.getIntExtra("sale_id", 0);
        customer.closeSale(sale_id, true);
    }
}
