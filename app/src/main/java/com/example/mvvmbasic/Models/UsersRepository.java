package com.example.mvvmbasic.Models;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import androidx.lifecycle.MutableLiveData;

public class UsersRepository {

    private String url = "https://api.github.com/users";
    private Application application;
    private Users[] users;

    private MutableLiveData<Users[]> mutableLiveData;

    public UsersRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<Users[]> getUserData(){

        if(mutableLiveData == null){

            mutableLiveData = new MutableLiveData<>();
        }

        RequestQueue requestQueue = Volley.newRequestQueue(application);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        users = gson.fromJson(response,Users[].class);
                        mutableLiveData.setValue(users);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);

        return mutableLiveData;
    }


}
