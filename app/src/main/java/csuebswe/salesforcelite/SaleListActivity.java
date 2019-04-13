package csuebswe.salesforcelite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import csuebswe.salesforcelite.model.Sale;

public class SaleListActivity extends AppCompatActivity implements SaleListViewAdapter.ItemClickListener {
    Map<Integer, Sale> sales;
    SaleListViewAdapter adapter;
    List<Sale> list_sales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saleslist);

        sales = (Map)getIntent().getSerializableExtra("salelist");
        list_sales = new ArrayList<>(sales.values());
        RecyclerView recyclerView = findViewById(R.id.rvSalesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SaleListViewAdapter(this, list_sales);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        // TODO: show the details of each sale in the list -- display all sale attributes
    }
}
