package com.example.apicalling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class GET_API_ParametersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_api_parameters);

        //API:-https://jsonplaceholder.typicode.com/posts
        //Method:-GET
        //Parameters:-1.userId 2.id

        //Just Example Any Place Set(Parameters)   //Just Information(?userId=4&id=34):-https://jsonplaceholder.typicode.com/posts ?userId=4&id=34
        int  username = 4;
        int password = 35;

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/posts?userId="+username+"&id="+password;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ResponseGET",""+response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorGET",""+error);
            }
        });

        queue.add(stringRequest);
    }
}