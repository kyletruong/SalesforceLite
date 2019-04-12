package csuebswe.salesforcelite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.List;
import csuebswe.salesforcelite.model.Sale;

public class CloseSaleActivity extends AppCompatActivity implements SaleListViewAdapter.ItemClickListener {
    List<Sale> sales;
    SaleListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saleslist);

        sales = (List)getIntent().getSerializableExtra("closesale");
        RecyclerView recyclerView = findViewById(R.id.rvCloseSale);

        // TODO: This is broken right now, can't accept/decline a sale
        // TODO: Might have to create a new view adapter? But should be able to reuse SaleListViewAdapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new SaleListViewAdapter(this, sales);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        /**
         * One-liner is equivalent to this:
         *
         * Sale sale = sales.get(index);
         * CustomerModel customer = sale.getCustomer();
         * customer.closeSale(sale.getId(), true);
         */
        sales.get(position).getCustomer().closeSale(sales.get(position).getId(), true);
        CloseSaleActivity.this.finish();
    }
}
