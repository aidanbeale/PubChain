package com.pubchain;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView beerCoins;
    private Button purchaseDrinkButton;

    private double tokenCount;
    ArrayList<Alcohol> alcohols = new ArrayList<>();
    ArrayList<Contact> contacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        createTestData();
        queryBlockchain("getToken");
        init();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {

            tokenCount = data.getDoubleExtra("beerTokens", 0);

            beerCoins.setText(String.valueOf(tokenCount));
        }

    }

    private void queryBlockchain(String query) {
        Intent i = new Intent(MainActivity.this, QueryBlockchain.class);
        i.putExtra("request", query);
        startActivityForResult(i, 0);
    }

    private void init() {
        beerCoins = (TextView) findViewById(R.id.beerCoins);
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

        contacts.add(new Contact("John Smith", "fakeNXTAddr"));
        contacts.add(new Contact("Julie Hansen", "fakeNXTAddr"));
        contacts.add(new Contact("Mason Shenton", "fakeNXTAddr"));
        contacts.add(new Contact("Hayden Garran", "fakeNXTAddr"));
        contacts.add(new Contact("Hannah Morwood", "fakeNXTAddr"));
        contacts.add(new Contact("Brayden Macaulay", "fakeNXTAddr"));
        contacts.add(new Contact("Joel Hansen", "fakeNXTAddr"));
    }


    public void purchaseDrinkPressed(View view) {
        //Intent i = new Intent(MainActivity.this, QueryBlockchain.class);
        //i.putExtra("request", "getToken");
        //startActivity(i);

        createTestData();

        //createTestData();

        // beer purchased
        // add to blockchain
        // update token count

        // Update transaction history activity?
    }

    private void updateUserInformation() {

    }

    public void displayHistory(View view) {
        Intent i = new Intent(MainActivity.this, DisplayHistory.class);
        i.putParcelableArrayListExtra("alcohols", alcohols);
        startActivity(i);
    }

    public void displayContacts(View view) {
        Intent i = new Intent(MainActivity.this, FriendsActivity.class);
        i.putParcelableArrayListExtra("contacts", contacts);
        startActivity(i);
    }
}
