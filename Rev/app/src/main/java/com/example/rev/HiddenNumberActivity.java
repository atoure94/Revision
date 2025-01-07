package com.example.rev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class HiddenNumberActivity extends AppCompatActivity {

    private int hiddenNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hidden_number);

        TextView loginTextView = findViewById(R.id.login_lab);
        EditText num_input = findViewById(R.id.num_input);
        TextView resTextView = findViewById(R.id.result_lab);
        Button verifButton = findViewById(R.id.verif_btn);
        Button quitButton = findViewById(R.id.quit_btn);

        Intent intent = getIntent();
        String login = intent.getStringExtra("user_email");
        loginTextView.setText("Utilisateur: " + login);

        Random random = new Random();
        hiddenNumber = random.nextInt(20)+1;

        verifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = num_input.getText().toString().trim();

                if(input.isEmpty()){
                    Toast.makeText(HiddenNumberActivity.this, "Put a number please", Toast.LENGTH_SHORT).show();
                    return;
                }

                int guessedNumber = Integer.parseInt(input);

                if(guessedNumber == hiddenNumber){
                    resTextView.setText("Bravo, Nombre caché trouvé : " + hiddenNumber);
                }else {
                    resTextView.setText("Nombre caché pas trouvé, essayé de nouveau");
                    if(guessedNumber < hiddenNumber){
                        Toast.makeText(HiddenNumberActivity.this, "Le nombre est plus grand que le votre ", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(HiddenNumberActivity.this, "Le nombre est plus petit que le votre", Toast.LENGTH_SHORT).show();
                    }

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