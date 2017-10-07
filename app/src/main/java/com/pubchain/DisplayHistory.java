package com.pubchain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.pubchain.R;

public class DisplayHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_history);
        setTitle("PubChain - Transaction History");
        //getActionBar().setIcon(R.drawable.my_icon);
        init();
    }

    private void init() {
        ArrayList<Alcohol> alcohols = (ArrayList<Alcohol>) getIntent().getSerializableExtra("alcohols");

        displayProductInformation(alcohols);
    }

    private void displayProductInformation(ArrayList<Alcohol> alcohols) {
        // Draw a new column for each location
        for (Alcohol a : alcohols) {
            createTableRow(a);
            //createTableRowFinal();
        }
    }

    private void createTableRowFinal() {
        final TableLayout detailsTable = (TableLayout) findViewById(R.id.mainTable);
        final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.tablerowgap, null);
        detailsTable.addView(tableRow);
    }

    private void createTableRow(Alcohol a) {

        final TableLayout detailsTable = (TableLayout) findViewById(R.id.mainTable);
        final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.tablerow, null);
        TextView tv;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        tv = (TextView) tableRow.findViewById(R.id.informationCell);
        tv.setText(a.getProductName() + "\n" + sdf.format(a.getTimestamp()) + "\n" + a.getBeerCoinValue() + " BeerCoins\n" + a.getStandardDrinks() + " standard drinks");

        //Add row to the table
        detailsTable.addView(tableRow);
    }
}
