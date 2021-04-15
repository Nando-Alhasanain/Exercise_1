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
                tvnomor.setText("08122233344");
                break;
            case "Ilham":
                tvnama.setText("Ilham R");
                tvnomor.setText("08166227722");
                break;
            case "Eris":
                tvnama.setText("Eris J");
                tvnomor.setText("08166833993");
                break;
            case "Fikri":
                tvnama.setText(" M  Fikri");
                tvnomor.setText("08155228822");
                break;
            case "Maul":
                tvnama.setText("Maul M");
                tvnomor.setText("08122663388");
                break;
            case "Intan":
                tvnama.setText("Intan S");
                tvnomor.setText("08155229911");
                break;
            case "Vina":
                tvnama.setText("Vina R");
                tvnomor.setText("08133262972");
                break;
            case "Gita":
                tvnama.setText("Gita S");
                tvnomor.setText("08112333444");
                break;
            case "Luthfi":
                tvnama.setText("Luthfi M");
                tvnomor.setText("08165242722");
                break;
            case "Vian":
                tvnama.setText("Vian M");
                tvnomor.setText("08162426288");
                break;
        }
    }
}