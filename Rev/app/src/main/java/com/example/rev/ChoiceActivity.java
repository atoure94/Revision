package com.example.rev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChoiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choice);

        TextView title = findViewById(R.id.choice_title);
        Button countViewBtn = findViewById(R.id.count_view_btn);
        Button guessViewBtn = findViewById(R.id.guess_view_btn);
        Button randomBtn = findViewById(R.id.rd_btn);


        Intent intent = getIntent();
        String login = intent.getStringExtra("user_email");
        title.setText("Hello User: " + login + ", Choose your Game");

        countViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String login = intent.getStringExtra("user_email");

                Intent intent2 = new Intent(ChoiceActivity.this, CountActivity.class);
                Toast.makeText(ChoiceActivity.this, "You choose Count Game", Toast.LENGTH_SHORT).show();
                intent2.putExtra("user_email", login);
                startActivity(intent2);
            }
        });

        guessViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String login = intent.getStringExtra("user_email");


                Intent intent2 = new Intent(ChoiceActivity.this, HiddenNumberActivity.class);
                Toast.makeText(ChoiceActivity.this, "You choose Guess Game", Toast.LENGTH_SHORT).show();
                intent2.putExtra("user_email", login);
                startActivity(intent2);
            }
        });



        randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(ChoiceActivity.this, RandomActivity.class);
            Toast.makeText(ChoiceActivity.this, "GO to the page of random things", Toast.LENGTH_SHORT);
            startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}