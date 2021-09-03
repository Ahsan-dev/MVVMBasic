package com.example.mvvmbasic.Adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mvvmbasic.Models.Users;
import com.example.mvvmbasic.R;
import com.example.mvvmbasic.ViewHolder.UserViewHolder;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Users[] users;

    public UserAdapter(Users[] users) {
        this.users = users;
    }

    @NonNull
    @NotNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull UserViewHolder holder, int position) {

        holder.nameTxt.setText(users[position].getLogin());
        holder.urlTxt.setText(users[position].getUrl());
        holder.gistUrlTxt.setText(users[position].getGistsUrl());

        Picasso.get().load(users[position].getAvatarUrl()).placeholder(R.drawable.ic_launcher_background).into(holder.proImage);

    }

    @Override
    public int getItemCount() {
        return users.length;
    }
}
