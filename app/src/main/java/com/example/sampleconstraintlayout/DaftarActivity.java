package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

public class DaftarActivity extends AppCompatActivity {

    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;
    Button fabS, fabB;

    private TextInputLayout TextInputAlamat, TextInputNama, TextInputEmail, TextInputPass, TextInputRepass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        edtNama = findViewById(R.id.edNama);
        edtAlamat = findViewById(R.id.edAlamat);
        edtEmail = findViewById(R.id.edEmail);
        edtPassword = findViewById(R.id.edPass);
        edtrepass = findViewById(R.id.edrepass);
        fabS = findViewById(R.id.fabSimpan);
        fabB = findViewById(R.id.fabBatal);

        TextInputNama = findViewById(R.id.textInputLayout);
        TextInputAlamat = findViewById(R.id.textInputLayout2);
        TextInputEmail = findViewById(R.id.textInputLayout3);
        TextInputPass = findViewById(R.id.textInputLayout4);
        TextInputRepass = findViewById(R.id.textInputLayout5);

        fabS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    TextInputNama.setError("*Nama Tidak Boleh Kosong");
                    TextInputAlamat.setError("*Alamat Tidak Boleh Kosong");
                    TextInputEmail.setError("*Email Tidak Boleh Kosong");
                    TextInputPass.setError("*Pass Tidak Boleh Kosong");
                    TextInputRepass.setError("*Repass Tidak Boleh Kosong");
                    Snackbar.make(view, "Wajib isi seluruh data !!!", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil...",
                                Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view, "Password dan Repassword harus sama!!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });

        fabB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }


}