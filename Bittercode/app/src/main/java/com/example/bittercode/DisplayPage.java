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
    private String cntxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_page);
        init();
    }

    public void init(){
        display =  (TextView) findViewById(R.id.de);
        goback = (Button) findViewById(R.id.goback);
        goback.setOnClickListener(this);
        cntxt= getIntent().getStringExtra("DECRYPT_STRING");
        display.setText(cntxt);
    }

    private void changeA() {
        Intent s = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(s);
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
