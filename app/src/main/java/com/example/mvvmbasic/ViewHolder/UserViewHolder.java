package com.example.mvvmbasic.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mvvmbasic.R;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    public TextView nameTxt, urlTxt, gistUrlTxt;
    public ImageView proImage;

    public UserViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);

        nameTxt = itemView.findViewById(R.id.nametextView);
        urlTxt = itemView.findViewById(R.id.urltextView);
        gistUrlTxt = itemView.findViewById(R.id.gisturltextView);
        proImage = itemView.findViewById(R.id.imageView);


    }
}
