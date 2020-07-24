package com.example.bittercode;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView message;
    private TextView decrypt;
    private TextView encrypt;

    private Button generate;
    private Button decode;

    private Crypto cro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        config();
        generateCrypto();

    }

    private void config()
    {
        message = (TextView) findViewById(R.id.message);
        decrypt = (TextView) findViewById(R.id.decrypt);
        encrypt = (TextView) findViewById(R.id.encrypt);

        generate = (Button) findViewById(R.id.generate);
        decode = (Button) findViewById(R.id.decode);

        generate.setOnClickListener(this);
        decode.setOnClickListener(this);
    }

    public void generateCrypto()
    {
        cro = new BasicCrypto();
        String m1 = "hello";
        String temp = new String(cro.encrypt(m1.getBytes()));
        String dec = new String(cro.decrypt(temp.getBytes()));

        showMessage("Message: " + m1 +"\nEncrypt:" + temp +"\nDecrypt: "+dec);
    }

    private void showMessage(String m)
    {
        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.generate:
                showMessage("Generate Button");
                break;
            case R.id.decode:
                showMessage("decode Button");
                break;
        }
    }
}