package com.example.apicalling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apicalling.Adapter.APIAdapter;
import com.example.apicalling.Class.ModelClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.API(Application Programming Interface)
        //2.Method Type (GET,POST)
        //3.Parameter

        //Volley Library(API)

        //Steps To Be Checked In After API Calling
        //1.Check URL Properly
        //2.Check Method Type
        //3.Check Parameter Key
        //4.Internet Permission
        //5.Device(Phone) Internet
        //6.Print All Logs
        //7.android:usesCleartextTraffic="true"


        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/posts";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            ArrayList<ModelClass> list = new ArrayList<>();

                            for(int i=0;i<jsonArray.length();i++){

                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String title = jsonObject.getString("title");
                                String body = jsonObject.getString("body");

                                ModelClass modelClass = new ModelClass(title,body);

                                list.add(modelClass);


                            }
                            recyclerView = findViewById(R.id.recyclerView);

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
                            recyclerView.setLayoutManager(linearLayoutManager);

                            APIAdapter apiAdapter = new APIAdapter(MainActivity.this,list);
                            recyclerView.setAdapter(apiAdapter);

                            Log.e("Response202",""+response);

                        } catch (JSONException e) {

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Response404",""+error);
            }
        });
        queue.add(stringRequest);



    }

}