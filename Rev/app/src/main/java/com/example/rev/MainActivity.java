package com.example.rev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Références aux vues
        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress);
        EditText passwordEditText = findViewById(R.id.editTextTextPassword);
        RadioButton radioButtonJoueur = findViewById(R.id.joueur_btn);
        RadioButton radioButtonAdmin = findViewById(R.id.admin_btn);
        Button loginButton = findViewById(R.id.log_btn);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Vérification si l'utilisateur est "Admin"
                if (!radioButtonJoueur.isChecked()) {
                    Toast.makeText(MainActivity.this, "Fonctionnalité non prise en charge", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Vérification des identifiants
                if (email.equals("test") && password.equals("test123")) {
                    Toast.makeText(MainActivity.this, "Authentification réussie", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ChoiceActivity.class);
                    intent.putExtra("user_email", email);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Échec d'authentification, vérifier votre login et/ou mot de passe !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
