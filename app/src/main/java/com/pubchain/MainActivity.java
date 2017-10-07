package com.pubchain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tokenCountTextView;
    private Button purchaseDrinkButton;

    private double tokenCount;
    ArrayList<Alcohol> alcohols = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        tokenCountTextView = (TextView) findViewById(R.id.tokenCountTextView);
        purchaseDrinkButton = (Button) findViewById(R.id.purchaseDrinkButton);
    }

    private void createTestData() {
        alcohols.add(new Alcohol("Carlton Draught", 5.0, 1.3));
        alcohols.add(new Alcohol("Carlton Light", 3.2, 0.9));
        alcohols.add(new Alcohol("Corona", 6.7, 1.8));
        alcohols.add(new Alcohol("Carlton Draught", 5.0, 1.3));
        alcohols.add(new Alcohol("Carlton Draught", 5.0, 1.3));
        alcohols.add(new Alcohol("Carlton Draught", 5.0, 1.3));
        alcohols.add(new Alcohol("Carlton Light", 3.2, 0.9));
        alcohols.add(new Alcohol("Corona", 6.7, 1.8));
        alcohols.add(new Alcohol("Carlton Draught", 5.0, 1.3));
        alcohols.add(new Alcohol("Carlton Draught", 5.0, 1.3));
        alcohols.add(new Alcohol("Carlton Draught", 5.0, 1.3));
        alcohols.add(new Alcohol("Carlton Light", 3.2, 0.9));
        alcohols.add(new Alcohol("Corona", 6.7, 1.8));
        alcohols.add(new Alcohol("Carlton Draught", 5.0, 1.3));
        alcohols.add(new Alcohol("Carlton Draught", 5.0, 1.3));

        Intent i = new Intent(MainActivity.this, QueryBlockchain.class);
        i.putParcelableArrayListExtra("alcohols", alcohols);
        startActivity(i);
    }


    public void purchaseDrinkPressed(View view) {
        Intent i = new Intent(MainActivity.this, QueryBlockchain.class);
        i.putExtra("request", "getToken");
        startActivity(i);

        //createTestData();

        // beer purchased
        // add to blockchain
        // update token count

        // Update transaction history activity?
    }

    private void updateUserInformation() {

    }

    public void displayHistory(View view) {
        Intent i = new Intent(MainActivity.this, QueryBlockchain.class);
        i.putExtra("request", "history");
        startActivity(i);
    }

}
