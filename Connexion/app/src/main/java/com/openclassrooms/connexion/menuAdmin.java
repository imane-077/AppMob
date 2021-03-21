package com.openclassrooms.connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.openclassrooms.connexion.client.recherche.FormDestination;

public class menuAdmin extends AppCompatActivity {

    Button ajoutDest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

        ajoutDest = findViewById(R.id.ajoutDest);

        ajoutDest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(menuAdmin.this, FormDestination.class);
                startActivity(i);
            }
        });
    }
}