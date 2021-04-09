package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityLihatData extends AppCompatActivity {
    TextView tvnama, tvnomor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        Bundle bundle = getIntent().getExtras();
        String nama = bundle.getString("a");

        tvnama = findViewById(R.id.tvNamaKontak);
        tvnomor = findViewById(R.id.tvNomorTelepon);

        switch (nama)
        {
            case "Inayah":
                tvnama.setText("Inayah R");
                tvnomor.setText("091111111");
                break;
            case "Ilham":
                tvnama.setText("Ilham R");
                tvnomor.setText("091111111");
                break;
            case "Eris":
                tvnama.setText("Eris J");
                tvnomor.setText("091111111");
                break;
            case "Fikri":
                tvnama.setText(" M  Fikri");
                tvnomor.setText("091111111");
                break;
            case "Maul":
                tvnama.setText("Maul M");
                tvnomor.setText("091111111");
                break;
            case "Intan":
                tvnama.setText("Intan S");
                tvnomor.setText("091111111");
                break;
            case "Vina":
                tvnama.setText("Vina R");
                tvnomor.setText("091111111");
                break;
            case "Gita":
                tvnama.setText("Gita S");
                tvnomor.setText("091111111");
                break;
            case "Luthfi":
                tvnama.setText("Luthfi M");
                tvnomor.setText("091111111");
                break;
            case "Vian":
                tvnama.setText("Vian M");
                tvnomor.setText("091111111");
                break;
        }
    }
}