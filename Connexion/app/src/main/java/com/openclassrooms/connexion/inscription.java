package com.openclassrooms.connexion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class inscription extends AppCompatActivity {

    private EditText editNom;
    private EditText editPrenom;
    private EditText editAdresse;
    private EditText editIdent;
    private EditText editMdp;
    private Button btnVali;

    private FirebaseAuth Auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // on convertit les objets en java
        editNom = (EditText)findViewById(R.id.editTextPersonName);
        editPrenom = (EditText)findViewById(R.id.editTextPrenom);
        editAdresse = (EditText)findViewById(R.id.editTextAddress);
        editIdent = (EditText)findViewById(R.id.editTextIdentifiant);
        editMdp = (EditText)findViewById(R.id.editTextPasswordI);
        btnVali = (Button)findViewById(R.id.Valider);

        Auth = FirebaseAuth.getInstance();

        btnVali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtNom = editNom.getText().toString();
                String txtPrenom = editPrenom.getText().toString();
                String txtAdresse = editAdresse.getText().toString();
                String txtEmail = editIdent.getText().toString();
                String txtPassword = editMdp.getText().toString();

                if (TextUtils.isEmpty(txtNom) || TextUtils.isEmpty(txtPrenom)  || TextUtils.isEmpty(txtAdresse)  || TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(inscription.this, "Vous devez remplir tous les champs!", Toast.LENGTH_SHORT).show();
                } else if (txtPassword.length() < 6){
                    Toast.makeText(inscription.this, "Le mot de passe est trop court!", Toast.LENGTH_SHORT).show();
                } else {
                    inscriptionCli(txtNom , txtPrenom, txtAdresse, txtEmail , txtPassword);
                }
            }
        });
    }
    private void inscriptionCli(final String nom, final String prenom, final String adresse, final String email, String password) {

        // méthode qui nous permet d'ajouter une personne dans firebase
        Auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(inscription.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(inscription.this, " Vous êtes inscrit!  ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(inscription.this , navigation.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(inscription.this, "Echec", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}