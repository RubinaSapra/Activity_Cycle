package com.ruby.activitynewcycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class showGuess extends AppCompatActivity {

    private Button showGuess;
    private EditText enterGuess;
    private final int REQUEST_CODE = 2;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE)
        {
            assert data!=null;
            String message = data.getStringExtra("message_back");
            Toast.makeText(showGuess.this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);
        showGuess = findViewById(R.id.buttonGuess);
        enterGuess = findViewById(R.id.editTextGuess);
        showGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guess=enterGuess.getText().toString().trim();
                if(!guess.isEmpty())
                {
                    Intent intent = new Intent(showGuess.this,newshowguess.class);
                    intent.putExtra("Guess",guess);
                    intent.putExtra("Name","Rubina");
                    intent.putExtra("Age",21);
                   // startActivity(intent);
                   startActivityForResult(intent,REQUEST_CODE);
                }
                else
                {
                    Toast.makeText(showGuess.this,"Enter Guess", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
