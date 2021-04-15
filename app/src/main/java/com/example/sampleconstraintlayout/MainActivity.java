package com.example.sampleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    public static final Pattern EMAIL_PATT
            = Pattern.compile("\\@"+"\\.");
    public static final Pattern PASS_PATT
            = Pattern.compile(".{6,}");

    Button btnLogin;
    EditText edemail, edpassword;
    TextView txtDaftar;
    String nama, password;

    private TextInputLayout textInputEmail;
    private TextInputLayout textInputPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDaftar = findViewById(R.id.txDaftar);
        btnLogin = findViewById(R.id.btSignIn);
        edemail = findViewById(R.id.adEmail);
        edpassword = findViewById(R.id.adPassword);

        textInputEmail = findViewById(R.id.textInputLayoutEmail);
        textInputPass = findViewById(R.id.textInputLayoutPass);

        txtDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
                startActivity(i);
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                String email="admin@mail.com";
                String pass ="123";

                if (nama.isEmpty() && password.isEmpty())
                {
                    textInputPass.setError("*Password Tidak Boleh Kosong");
                    textInputEmail.setError("*Email Tidak Boleh Kosong");
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan password wajib diisi!!!", Toast.LENGTH_LONG);
                    t.show();

                }
                else if (!EMAIL_PATT.matcher(nama).matches()){
                    textInputEmail.setError("masukkan email dengan benar");
                }
                else if (!PASS_PATT.matcher(password).matches()){
                    textInputPass.setError("*Panjang Password minimal 6 Karakter");
                }

                else
                {
                    if (nama.equals(email) && password.equals(pass))
                    {

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses", Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();
                        b.putString("a", nama.trim());
                        b.putString("b", password.trim());
                        Intent i = new Intent(getApplicationContext(), Home_Activity.class);
                        i.putExtras(b);
                        startActivity(i);
                    }
                    else
                    {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);
                        t.show();
                    }
                }

            }
        });


    }

}