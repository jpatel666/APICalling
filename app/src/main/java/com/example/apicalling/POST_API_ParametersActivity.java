package com.example.apicalling;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

        //POST API Calling Using Volley Library

        //URL:-https://jsonplaceholder.typicode.com/posts
        //Parameters Key:-userId, id
        //Parameters Value:-9, 83
        //Method:-POST


        //Parameters Set
        String UserID = "9";
        String ID = "83";

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/posts";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("ResponsePOST", "" + response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ErrorPOST", "" + error);
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                HashMap hashMap = new HashMap();

                hashMap.put("userId", UserID);
                hashMap.put("id", ID);

                return hashMap;

                /* HashMap hashMap = new HashMap();

                hashMap.put("id", ""+1);
                hashMap.put("title", ""+"iPhone 9");

                return hashMap; */
            }
        };

        queue.add(stringRequest);
    }


}








