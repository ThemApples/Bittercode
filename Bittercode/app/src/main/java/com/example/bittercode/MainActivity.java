package com.example.bittercode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView message;
    private TextView encrypt;

    private Button generate;
    private Button decode;
    private Button information;
    private Button copy_clip;

    private String s_message;
    private String s_encrypt;
    private String s_decrypt;
    private String storage;

    private String special;
    private String special2;
    private Crypto cro;
    private String placeholder1;
    private String placeholder2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        config();
        //setToolBar();
        generateCrypto();
    }

    private void config() {
        message = (TextView) findViewById(R.id.message);
        encrypt = (TextView) findViewById(R.id.encrypt);
        information = (Button) findViewById(R.id.info);
        copy_clip = (Button) findViewById(R.id.copy_clipboard_encrypted);

        generate = (Button) findViewById(R.id.generate);
        decode = (Button) findViewById(R.id.decode);

        generate.setOnClickListener(this);
        decode.setOnClickListener(this);
        information.setOnClickListener(this);
        copy_clip.setOnClickListener(this);
    }

    private void setToolBar() {
       // Toolbar toolb = findViewById(R.id.toolbar);
        //toolb.setTitle("Bittercode");
        //setSupportActionBar(toolb);

    }

    public void generateCrypto()
    {
        cro = new BasicCrypto();
        getMessage();
    }

    private void get_encryption()
    {
        storage = encrypt.getText().toString();
    }

    private void encryptData()
    {
        s_encrypt = new String(cro.encrypt(s_message.getBytes()));
    }

    private void decyptData()
    {
        s_decrypt = new String(cro.decrypt(storage.getBytes()));
    }

    private void getMessage()
    {
        s_message = message.getText().toString();
    }

    private void showMessage(String m) {
        Toast.makeText(getApplicationContext(), m, Toast.LENGTH_SHORT).show();
    }

    public void confusion(String code)
    {
        char[] ch = code.toCharArray();
        String nMessage = "";
        StringBuilder sb =  new StringBuilder(nMessage);

        for (char i =0; i<ch.length;i++)
        {
            sb.append(ch[i]+=ch.length);
        }

        placeholder1 = sb.toString();
        special = placeholder1;
        //showMessage("1: " + sb.toString());
    }

    public void goback(String code)
    {
        char[] ch = code.toCharArray();
        String nMessage = "";
        StringBuilder sb =  new StringBuilder(nMessage);

        for (char i =0; i<ch.length;i++)
        {
            sb.append(ch[i]-=ch.length);
        }

        placeholder2 = sb.toString();
        storage = placeholder2;
        //showMessage("1");
    }

    private void specialEncryption()
    {
        special = "";
        for(int i =s_encrypt.length() - 1; i>=0 ;i--){
            special = special + s_encrypt.charAt(i);
        }
        confusion(special);
    }

    private void specialEncryption2()
    {
        special2 = "";
        goback(storage);
        try {
            for(int i =storage.length()-1; i>=0 ;i--){
                special2 = special2 + storage.charAt(i);
                //showMessage("s2"+special2);
            }
            storage = special2;
        }catch (NullPointerException e) {
            showMessage("1: These is no message by with this code.\nPlease place a new code into the decrypt section.");
        }
    }

    public void changeAct()
    {
        Intent i = new Intent(getApplicationContext(),DisplayPage.class);
        i.putExtra("DECRYPT_STRING",s_decrypt);
        startActivity(i);
        finish();
    }

    public void changeInfo()
    {
        Intent i = new Intent(getApplicationContext(),InformationPage.class);
        startActivity(i);
        finish();
    }

    public void checkNUll() {
       try {
           get_encryption();
           specialEncryption2();
           decyptData();
           changeAct();
       }catch (NullPointerException e) {
           showMessage("2: There is nothing in the decryption slot.\nPlease place your code in before pressing the decrypt button");
       }
    }

    private void clip_copy(){

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Simple text", placeholder1);
        clipboard.setPrimaryClip(clip);
        showMessage(placeholder1+" has been copied to clipboard");

        try{
            if(placeholder1.isEmpty()){
                showMessage("Nothing is printed");
            }
        }catch (NullPointerException e){
            showMessage("Nothing is copied cause there is nothing in the decrypt function");
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.generate:
                //showMessage("Generate Button");
                generateCrypto();
                encryptData();
                specialEncryption();
                encrypt.setText(special);
                break;
            case R.id.decode:
                //showMessage("decode Button");
                checkNUll();
                break;
            case R.id.info:
                //showMessage("Information Button");
                changeInfo();
                break;
            case R.id.copy_clipboard_encrypted:
                //showMessage("Copy To clipboard pressed");
                clip_copy();
                break;
        }
    }
}