package com.example.mvvmbasic.ViewModel;

import android.app.Application;

import com.example.mvvmbasic.Models.Users;
import com.example.mvvmbasic.Models.UsersRepository;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends AndroidViewModel {

    UsersRepository usersRepository;


    public MainActivityViewModel(@NonNull @NotNull Application application) {
        super(application);
        usersRepository = new UsersRepository(application);
    }

    public LiveData<Users[]> getAllData(){

        return usersRepository.getUserData();

    }


}
