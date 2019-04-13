package csuebswe.salesforcelite.controller;

import android.content.Context;
import android.content.Intent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import csuebswe.salesforcelite.CloseSaleActivity;
import csuebswe.salesforcelite.model.Sale;

public class CloseSale implements MenuItem, Serializable {
    List<Sale> sales;
    String saleType;

    /**
     * Constructor
     *
     * @param saleType      This should be either open sales / closed sales
     * @param sales         List of sale objects belonging to Employee or customer
     */
    public CloseSale(String saleType, Map<Integer, Sale> sales) {
        this.sales = new ArrayList<>(sales.values());
        this.saleType = saleType;
    }

    // **IMPORTANT**
    // the 'saleslist' string is a key for deserialization
    @Override
    public void execute(Context callingContext) {
        Intent intent = new Intent(callingContext, CloseSaleActivity.class);
        intent.putExtra("closesale", (Serializable)sales);
        callingContext.startActivity(intent);
    }

    @Override
    public String toString() {
        return saleType;
    }

    @Override
    public Intent getIntent(Context callingContext) {
        Intent intent = new Intent(callingContext, CloseSaleActivity.class);
        return intent;
    }
}
