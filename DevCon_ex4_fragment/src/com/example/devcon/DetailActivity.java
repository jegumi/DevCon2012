package com.example.devcon;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.devcon_exampl1.R;

public class DetailActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        getActionBar().setHomeButtonEnabled(true);
        DetailFragment frag = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        frag.setName(getIntent().getStringExtra("name"));
    }
}
