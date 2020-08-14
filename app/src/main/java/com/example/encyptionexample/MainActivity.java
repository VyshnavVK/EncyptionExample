package com.example.encyptionexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pvryan.easycrypt.ECResultListener;
import com.pvryan.easycrypt.symmetric.ECSymmetric;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {
EditText data,output;
Button encrypt,decrypt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = findViewById(R.id.data);
        encrypt = findViewById(R.id.encrypt);
        output = findViewById(R.id.output);
        decrypt = findViewById(R.id.decrypt);



encrypt.setOnClickListener(new View.OnClickListener() {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View view) {
        if(data.getText().toString().isEmpty()){
            Toast.makeText(MainActivity.this, "some of the data missing", Toast.LENGTH_SHORT).show();
        }else {
            try {
                output.setText(CryptoHandler.getInstance().encrypt(data.getText().toString()));
                data.setText("");
            }catch (Exception e){
                e.printStackTrace();
            }
            }
    }
});

        decrypt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View view) {
                if(output.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "some of the data missing", Toast.LENGTH_SHORT).show();
                }else {
                    try {
                        data.setText(CryptoHandler.getInstance().decrypt(output.getText().toString()));
                        output.setText("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
}