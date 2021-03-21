package com.openclassrooms.connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Accueil extends AppCompatActivity {

    Button btnCon;
    Button btnVisite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        btnCon = (Button)findViewById(R.id.boutonConnex);
        btnVisite = (Button)findViewById(R.id.boutonVisiter);

        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Accueil.this, PageCoAdCli.class);
                startActivity(i);
            }
        });
        btnVisite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Accueil.this,VisiteleSite.class);
                startActivity(i);
            }
        });
    }

}