package csuebswe.salesforcelite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import csuebswe.salesforcelite.model.Sale;

public class CloseSaleActivity extends AppCompatActivity implements SaleListViewAdapter.ItemClickListener {
    Map<Integer, Sale> sales;
    SaleListViewAdapter adapter;
    List<Sale> list_sales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saleslist);

        sales = (Map)getIntent().getSerializableExtra("closesale");
        RecyclerView recyclerView = findViewById(R.id.rvSalesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list_sales = new ArrayList<>(sales.values());

        adapter = new SaleListViewAdapter(this, list_sales);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    // TODO: Change the sale in CustomerActivity instead of this activity
    @Override
    public void onItemClick(View view, int position) {
        /**
         * One-liner is equivalent to this:
         *
         * Sale sale = sales.get(index);
         * CustomerModel customer = sale.getCustomer();
         * customer.closeSale(sale.getId(), true);
         */
        //sales.get(position).getCustomer().closeSale(sales.get(position).getId(), true);

        int sale_id = (list_sales.get(position).getId());
        Intent intent = new Intent();
        intent.putExtra("sale_id", sale_id);
        setResult(1, intent);
        CloseSaleActivity.this.finish();
    }
}
