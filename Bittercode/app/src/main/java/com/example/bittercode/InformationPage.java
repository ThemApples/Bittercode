package com.example.bittercode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InformationPage extends AppCompatActivity implements View.OnClickListener {
    private TextView title;
    private TextView description;
    private Button contin;
    private Button close;

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
        close = findViewById(R.id.close);

        close.setOnClickListener(this);

        contin = findViewById(R.id.cont);
        contin.setOnClickListener(this);
        contin.setVisibility(View.INVISIBLE);

        title.setText("How to use");
        description.setText("The message box is for the user to write there message.\n" +
                "\n" +
                "To encrypt the message the user  simply needs to press the encryption button.\n" +
                "\n" +
                "Once the encryption button is pressed a key will be generate for the user to copy.\n" +
                "\n" +
                "To view messages secret messages, paste your or your friends key into the encryption message box. " +
                "Then Press the Decrypt message Button.\n" +
                "\n" +
                "This will bring you to a new page just to view the secret message. \n" +
                "\n" +
                "Note: \n" +
                "If the resulting message is random characters, you have placed the wrong key. ");
    }

    private void showMessage(String m) {
        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
    }

    private void close()
    {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.close:
                //showMessage("close button pressed");
                close();
                break;
        }
    }
}
