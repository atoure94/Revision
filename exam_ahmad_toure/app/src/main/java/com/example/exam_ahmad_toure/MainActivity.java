package com.example.exam_ahmad_toure;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText nameEditText = findViewById(R.id.name_lab);
        EditText passwordEditText = findViewById(R.id.password_lab);
        Button loginBtn = findViewById(R.id.login_btn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (name.equals("test") && password.equals("test123")) {
                    Toast.makeText(MainActivity.this, "Authentification réussie", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, CountActivity.class);
                    intent.putExtra("user_email", name);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Échec d'authentification, vérifier votre login et/ou mot de passe !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}