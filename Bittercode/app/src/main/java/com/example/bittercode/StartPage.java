package com.example.bittercode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StartPage extends AppCompatActivity implements View.OnClickListener{

    private TextView title;
    private TextView description;
    private Button contin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);
        setup();
    }

    public void setup()
    {
        title = findViewById(R.id.t);
        description = findViewById(R.id.t2);
        contin = findViewById(R.id.cont);

        title.setText("Welcome");
        description.setText("Bittercode is a program that allows \n" +
                "the user to encrypt data and send it off to \n" +
                "someone else to see.\n" +
                "You could even use to store certain \n" +
                "messages important messages.");
        contin.setOnClickListener(this);
    }

    private void showMessage(String m) {
        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.cont:
                showMessage("continue button presses");
                break;
        }
    }
}
