package com.example.apicalling;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

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

        //GET API Calling Using Volley Library With Parameters

        //URL:-https://jsonplaceholder.typicode.com/posts
        //Parameters Key:-userId, id
        //Parameters Value:-9, 87
        //Method:-GET

        //Parameters Set   //(?userId=9&id=87):-https://jsonplaceholder.typicode.com/posts ?userId=4 & id=34
        String UserID = "9";
        String ID = "87";

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/posts?userId=" + UserID + "&id=" + ID;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ResponseGET", "" + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorGET", "" + error);
            }
        });

        queue.add(stringRequest);
    }
}