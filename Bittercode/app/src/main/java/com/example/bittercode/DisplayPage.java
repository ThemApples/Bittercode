package com.example.bittercode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayPage extends AppCompatActivity implements View.OnClickListener{

    private TextView display;
    private Button goback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_page);
        display =  (TextView) findViewById(R.id.de);
        goback = (Button) findViewById(R.id.goback);
    }

    private void changeA() {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.goback:
                changeA();
                break;
        }
    }
}
