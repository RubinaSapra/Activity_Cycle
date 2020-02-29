package com.ruby.activitynewcycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class newshowguess extends AppCompatActivity {
private TextView showTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newshowguess);

        Bundle extra= getIntent().getExtras();
          showTextView = findViewById(R.id.getGuess);
        if(extra!=null) {
            showTextView.setText(extra.getString("Guess"));
            Log.d("Name Extra","On create "+extra.getString("Name"));
            Log.d("Age Extra","On create "+extra.getInt("Age"));
        }
        showTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                intent.putExtra("message_back","SEond Activity ");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
//          if(getIntent().getStringExtra("Guess")!=null) {
//              String value = getIntent().getStringExtra("Guess");
//              showTextView.setText(value);
//          }

    }
}
