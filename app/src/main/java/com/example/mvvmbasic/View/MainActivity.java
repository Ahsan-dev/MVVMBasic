package com.example.mvvmbasic.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmbasic.Adapter.UserAdapter;
import com.example.mvvmbasic.Models.Users;
import com.example.mvvmbasic.R;
import com.example.mvvmbasic.ViewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel;
    private RecyclerView recyclerView;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        recyclerView = findViewById(R.id.recycler_view_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        mainActivityViewModel.getAllData().observe(this, new Observer<Users[]>() {
            @Override
            public void onChanged(Users[] users) {

                adapter = new UserAdapter(users);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });


    }
}