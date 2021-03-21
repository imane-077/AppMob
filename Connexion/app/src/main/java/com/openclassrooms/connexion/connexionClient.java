package com.openclassrooms.connexion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class connexionClient extends AppCompatActivity {

    private EditText edit1;
    private EditText edit2;
    private Button btnVal;
    private Button btnInscp;

    private FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co_);

        edit1 = (EditText)findViewById(R.id.editTextName); // c'est l'email
        edit2 = (EditText)findViewById(R.id.editTextPassword); // convertit
        btnVal = (Button)findViewById(R.id.button);
        btnInscp = (Button)findViewById(R.id.buttonInscp);
        Auth = FirebaseAuth.getInstance();

        btnVal.setOnClickListener(new View.OnClickListener() {
            @Override
            // quand on clique sur le bouton, on vérifie que la personne a entré toutes les données
            public void onClick(View v) {
                String txtEmail = edit1.getText().toString();
                String txtPassword = edit2.getText().toString();
                if ( TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(connexionClient.this, "Vous devez remplir tous les champs!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Identification(txtEmail, txtPassword);
                }
            }
        });

        btnInscp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(connexionClient.this,inscription.class);
                startActivity(i);
            }
        });
    }
    // fonction qui vérifie si la personne est déjà dans la base ou pas
    // si la personne n'est pas dans la base, rien ne se passe sinon elle sera redirigé vers une autre page
    private void Identification(String Email, String Password) {
        Auth.signInWithEmailAndPassword(Email , Password).addOnSuccessListener(connexionClient.this,new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(connexionClient.this, " Vous êtes connecté ! ", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(connexionClient.this, navigation.class);
                startActivity(i);
            }
        });
    }
}