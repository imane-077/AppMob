package com.openclassrooms.connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PageCoAdCli extends AppCompatActivity {

    ImageButton cli;
    ImageButton admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_co_ad_cli);

        cli = (ImageButton)findViewById(R.id.imageButtonCli);
        admin = (ImageButton)findViewById(R.id.imageButtonAd);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PageCoAdCli.this,connexionAdmin.class);
                startActivity(i);
            }
        });

        cli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(PageCoAdCli.this, connexionClient.class);
                startActivity(j);
            }
        });
    }
}