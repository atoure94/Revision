package com.example.rev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CountActivity extends AppCompatActivity {

    int lionCounter=0;
    int elephantCounter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_count);


        TextView loginLab= findViewById(R.id.log_lab);
        RadioButton lionButton = findViewById(R.id.lion_button);
        RadioButton elephantButton = findViewById(R.id.elephants_button);
        TextView lionCount= findViewById(R.id.lions_count);
        TextView elephantCount = findViewById(R.id.elephants_count);
        Button countButton = findViewById(R.id.count_btn);
        Button quitButton = findViewById(R.id.quit_button);

        Intent intent = getIntent();
        String login = intent.getStringExtra("user_email");
        loginLab.setText("Utilisateur: " + login);

        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(lionButton.isChecked()){
                    lionCounter++;
                    lionCount.setText("Lions: " + lionCounter);
                } else if (elephantButton.isChecked()) {
                    elephantCounter++;
                    elephantCount.setText("Elephants: " + elephantCounter);
                }

            }
        });

        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}