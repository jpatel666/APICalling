package com.example.apicalling;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class POST_API_ParametersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_api_parameters);

        //API:-https://jsonplaceholder.typicode.com/posts
        //Method:-POST
        //Parameters:-1.userId 2.id


        //Just Example Any Place Set   //Just Information(?userId=4&id=34):-https://jsonplaceholder.typicode.com/posts?userId=4&id=34
        int  username = 5;
        int password = 36;

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/posts";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ResponsePOST",""+response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorPOST",""+error);
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap hashMap = new HashMap();

                hashMap.put("userId",username);
                hashMap.put("id",password);

                return hashMap;
            }
        };

        queue.add(stringRequest);
    }


}