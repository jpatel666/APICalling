package com.example.apicalling.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apicalling.Class.ModelClass;
import com.example.apicalling.MainActivity;
import com.example.apicalling.R;

import java.util.ArrayList;

public class APIAdapter extends RecyclerView.Adapter<APIAdapter.MyClass> {
    MainActivity mainActivity;
    ArrayList<ModelClass> list;

    public APIAdapter(MainActivity mainActivity, ArrayList<ModelClass> list) {
        this.mainActivity = mainActivity;
        this.list = list;
    }

    @NonNull
    @Override
    public APIAdapter.MyClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mainActivity).inflate(R.layout.app_design_layout, parent, false);
        MyClass myClass = new MyClass(view);
        return myClass;
    }

    @Override
    public void onBindViewHolder(@NonNull APIAdapter.MyClass holder, int position) {

        ModelClass modelClass = list.get(position);
        String title = modelClass.getTitle();
        holder.tvTitle.setText(title);
        String body = modelClass.getBody();
        holder.tvBody.setText(body);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyClass extends RecyclerView.ViewHolder {

        TextView tvTitle, tvBody;

        public MyClass(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);
        }
    }
}
