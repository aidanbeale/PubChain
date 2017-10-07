package com.pubchain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        init();
    }

    private void init() {
        ArrayList<Contact> contacts = (ArrayList<Contact>) getIntent().getSerializableExtra("contacts");

        displayProductInformation(contacts);
    }

    private void displayProductInformation(ArrayList<Contact> contacts) {
        // Draw a new column for each location
        for (Contact c : contacts) {
            createTableRow(c);
            createTableRowGap();
        }
    }

    private void createTableRowGap() {

        final TableLayout detailsTable = (TableLayout) findViewById(R.id.mainTable);
        final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.tablerowgap, null);
        TextView tv;

        //Add row to the table
        detailsTable.addView(tableRow);
    }

    private void createTableRow(Contact c) {

        final TableLayout detailsTable = (TableLayout) findViewById(R.id.mainTable);
        final TableRow tableRow = (TableRow) getLayoutInflater().inflate(R.layout.tablerowfriend, null);
        TextView tv;

        final String contactName = c.getName();
        final String nxtAddr = c.getNxtAddr();

        tv = (TextView) tableRow.findViewById(R.id.informationCell);
        tv.setText(c.getName());

        Button button = (Button) tableRow.findViewById(R.id.sendBeerCoins);

        button.setOnClickListener(new View.OnClickListener() {
                                      @Override public void onClick(View v) {
                                          Intent i = new Intent(FriendsActivity.this, FriendInfo.class);
                                          i.putExtra("contactName", contactName);
                                          i.putExtra("nxtAddr", nxtAddr);
                                          startActivity(i);
                                      }
                                  });
        //Add row to the table
        detailsTable.addView(tableRow);
    }
}
