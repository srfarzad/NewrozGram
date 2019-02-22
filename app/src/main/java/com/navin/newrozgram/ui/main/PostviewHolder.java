package com.navin.newrozgram.ui.main;

import android.view.View;

import com.navin.newrozgram.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PostviewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.img_user_profile) AppCompatImageView img_user_profile;
    @BindView(R.id.txt_username) AppCompatTextView txt_username;
    @BindView(R.id.pager)ViewPager pager;

    public PostviewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
