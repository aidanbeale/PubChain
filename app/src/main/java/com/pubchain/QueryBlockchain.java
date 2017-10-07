package com.pubchain;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QueryBlockchain extends AppCompatActivity {

    String URL = "http://ec2-52-62-186-191.ap-southeast-2.compute.amazonaws.com:3000";

    ArrayList<Alcohol> alcohols;
    double tokenCount = 0.0;

    JSONObject jsonBody;
    String requestBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_blockchain);

        manageRequests();
    }

    private void manageRequests() {
        Bundle extras = getIntent().getExtras();
        if (extras.get("request").equals("getHistory")) {
            makeDrinksRequest();
        } else if (extras.get("request").equals("getToken")) {
            makeTokenGetCountRequest();
        } else if (extras.get("request").equals("sendToken")) {
            makeTokenSetCountRequest();
        }

    }

    private void makeDrinksRequest() {
        RequestQueue queue = Volley.newRequestQueue(QueryBlockchain.this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Dis good:" + response, Toast.LENGTH_LONG).show();
                JsonObject jsonResponse = stringToJsonObject(response);
                String result = jsonResponse.getString("result", "actionError");

                //tokenCount = Double.valueOf(stringCount) / 10;

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.print(error.toString());

                Toast.makeText(getApplicationContext(), "Error querying server\nError Code: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            //adding parameters to the request
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("acc", ""); // TODO params
                System.out.println("Parameters: " + params);
                return params;
            }
        };
        // Add the request to the RequestQueue.
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(60 * 1000, 0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);
    }

    private void makeTokenSetCountRequest() {
        RequestQueue queue = Volley.newRequestQueue(QueryBlockchain.this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() { // TODO Request type

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Dis good:" + response, Toast.LENGTH_LONG).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.print(error.toString());

                Toast.makeText(getApplicationContext(), "Error querying server\nError Code: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            //adding parameters to the request
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("accAddr", "NXT-QBU9-KSX6-6TH4-H47LR");
                return params;
            }
        };
        // Add the request to the RequestQueue.
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(60 * 1000, 0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);
    }

    private void makeTokenGetCountRequest() {
        String customURL = URL + "/getbalance";

        RequestQueue queue = Volley.newRequestQueue(QueryBlockchain.this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, customURL, new Response.Listener<String>() { // TODO Request type

            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Dis good:" + response, Toast.LENGTH_LONG).show();
                JsonObject jsonResponse = stringToJsonObject(response);
                String beerTokensString = jsonResponse.getString("balanceNQT", "actionError");
                double beerTokens = Double.valueOf(beerTokensString) / 100000000;
                System.out.println(beerTokens);

                Intent i = new Intent();
                i.putExtra("beerTokens", beerTokens);
                setResult(2, i);
                finish();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.print(error.toString());

                Toast.makeText(getApplicationContext(), "Error querying server\nError Code: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            //adding parameters to the request
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("accAddr", "NXT-QBU9-KSX6-6TH4-H47LR");
                System.out.println("Parameters: " + params);
                return params;
            }
        };
        // Add the request to the RequestQueue.
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(60 * 1000, 0,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(stringRequest);
    }

    private JsonObject stringToJsonObject(String stringToJson) {
        JsonValue jsonResponse;

        try {
            // Parses the string response into a JsonValue
            jsonResponse = Json.parse(stringToJson);
            // Converts the JsonValue into an Object
            JsonObject objectResponse = jsonResponse.asObject();
            // Returns JsonObject
            return objectResponse;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    }
