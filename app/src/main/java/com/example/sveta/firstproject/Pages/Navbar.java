package com.example.sveta.firstproject.Pages;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.sveta.firstproject.R;

public class Navbar {

    Activity activity;

    ImageView buttonMap;
    ImageView buttonNews;
    ImageView buttonInfo;
    ImageView buttonHostels;

    private int idCurrentButton;

    public Navbar(Activity activity){
        this.activity = activity;
        initialButtons();
        idCurrentButton = buttonMap.getId();
        setCurrecntButton(idCurrentButton);
    }

    private void initialButtons() {

        buttonMap  = (ImageView) activity.findViewById(R.id.button_map);
        buttonNews = (ImageView) activity.findViewById(R.id.button_news);
        buttonInfo = (ImageView) activity.findViewById(R.id.button_info);
        buttonHostels = (ImageView) activity.findViewById(R.id.button_hostels);

        buttonMap.setOnClickListener(buttonMapListener);
        buttonNews.setOnClickListener(buttonNewsListener);
        buttonInfo.setOnClickListener(buttonInfoListener);
        buttonHostels.setOnClickListener(buttonHostelsListener);
    }

    View.OnClickListener buttonMapListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setCurrecntButton(buttonMap.getId());
        }
    };

    View.OnClickListener buttonNewsListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setCurrecntButton(buttonNews.getId());
        }
    };

    View.OnClickListener buttonInfoListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setCurrecntButton(buttonInfo.getId());
        }
    };

    View.OnClickListener buttonHostelsListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setCurrecntButton(buttonHostels.getId());
        }
    };


    private void setCurrecntButton(int idButton) {
        ((ImageView)activity.findViewById(idCurrentButton)).setSelected(false);
        idCurrentButton = idButton;
        ((ImageView)activity.findViewById(idCurrentButton)).setSelected(true);
    }
}
