package pubchaincom.pubchain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pubchain.QueryBlockchain;

public class MainActivity extends AppCompatActivity {

    private TextView tokenCountTextView;
    private Button purchaseDrinkButton;

    private double tokenCount;

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

    public void purchaseDrinkPressed(View view) {
        Intent i = new Intent(MainActivity.this, QueryBlockchain.class);
        startActivity(i);

        // beer purchased
        // add to blockchain
        // update token count

        // Update transaction history activity?
    }

    private void updateUserInformation() {

    }

}
