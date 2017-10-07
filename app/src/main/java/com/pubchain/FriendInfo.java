package com.pubchain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FriendInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_info);
        init();
    }

    private void init() {
        Bundle extras = getIntent().getExtras();

        String contactName = extras.getString("contactName");
        String nxtAddr = extras.getString("nxtAddr");

        TextView contactNameTextView = (TextView) findViewById(R.id.contactName);
        contactNameTextView.setText(contactName);
    }

    public void sendBeerCoin(View view) {
        // do transaction here
    }

}
