package com.example.bittercode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView message;
    private TextView decrypt;
    private TextView encrypt;

    private Button generate;
    private Button decode;

    private String s_message;
    private String s_encrypt;
    private String s_decrypt;

    private String special;
    private String special2;
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
        getMessage();
        //showMessage("Message: " + s_message +"\nEncrypt:" + s_encrypt +"\nDecrypt: "+ s_decrypt);
    }

    private void getdecypt()
    {
        s_decrypt = encrypt.getText().toString();
    }

    private void encryptData()
    {
        s_encrypt = new String(cro.encrypt(s_message.getBytes()));
    }

    private void decyptData()
    {
        s_decrypt = new String(cro.decrypt(special2.getBytes()));
    }

    private void getMessage()
    {
        s_message = message.getText().toString();
    }

    private void showMessage(String m)
    {
        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
    }

    private void specialEncryption()
    {
        special = "";
        //int i = str.length() - 1; i >= 0; i--
        for(int i =s_encrypt.length() - 1; i>=0 ;i--){
            special = special + s_encrypt.charAt(i);
        }

        showMessage(special);
    }

    private void specialEncryption2()
    {
        special2 = "";
        //int i = str.length() - 1; i >= 0; i--
        for(int i =s_encrypt.length() - 1; i>=0 ;i--){
            special2 = special2 + s_decrypt.charAt(i);
        }
        showMessage(special2);
    }



    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.generate:
                showMessage("Generate Button");
                generateCrypto();
                encryptData();
                specialEncryption();
                encrypt.setText(special);
                break;
            case R.id.decode:
                showMessage("decode Button");
                getdecypt();
                specialEncryption2();
                decyptData();
                decrypt.setText(s_decrypt);
                break;
        }
    }
}