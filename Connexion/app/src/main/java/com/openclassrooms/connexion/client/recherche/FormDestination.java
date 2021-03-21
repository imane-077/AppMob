package com.openclassrooms.connexion.client.recherche;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.openclassrooms.connexion.Accueil;
import com.openclassrooms.connexion.R;
import com.openclassrooms.connexion.navigation;

import java.text.DateFormat;
import java.util.Calendar;

public class FormDestination extends Fragment {

    private static final String TAG = "FormDestination";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_recherche, container, false);
        final Button button = root.findViewById(R.id.deconnecter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // passer d'un fragment à une activity
                Intent intent = new Intent(getActivity(), Accueil.class); // quand on est dans un fragment on doit mettre getActivity()
                ((navigation) getActivity()).startActivity(intent); // navigation : point d'entrée des fragments
            }
        });
        return root;
    }
}
