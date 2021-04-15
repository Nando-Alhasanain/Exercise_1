package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;
import android.view.Menu;
import android.text.TextUtils;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ListView list;
    private ListViewAdapter adapter;
    String[] listNama;
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    Bundle bundle = new Bundle();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);



        listNama = new String[]{"Inayah", "Ilham", "Eris", "Fikri", "Maul", "Intan", "Vina",
        "Gita", "Luthfi", "Vian"};
        list = findViewById(R.id.listKontak);
        classNamaArrayList = new ArrayList<>();

        for (int i = 0; i < listNama.length; i++)
        {
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);
        }

        adapter = new ListViewAdapter(this);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String nama = classNamaArrayList.get(position).getName();
                bundle.putString("a",nama.trim());
                PopupMenu pm = new PopupMenu(getApplicationContext(),view);

                pm.setOnMenuItemClickListener(Home_Activity.this);
                pm.inflate(R.menu.popup_menu);
                pm.show();
            }

        });
    }




    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        String nama = bundle.getString("a");
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnnomor:

                switch (nama)
                {
                    case "Inayah":
                        Toast.makeText(getApplicationContext(), "08122233344", Toast.LENGTH_LONG).show();
                        break;
                    case "Ilham":
                        Toast.makeText(getApplicationContext(), "08166227722", Toast.LENGTH_LONG).show();
                        break;
                    case "Eris":
                        Toast.makeText(getApplicationContext(), "08166833993", Toast.LENGTH_LONG).show();
                        break;
                    case "Fikri":
                        Toast.makeText(getApplicationContext(), "08155228822", Toast.LENGTH_LONG).show();
                        break;
                    case "Maul":
                        Toast.makeText(getApplicationContext(), "08122663388", Toast.LENGTH_LONG).show();
                        break;
                    case "Intan":
                        Toast.makeText(getApplicationContext(), "08155229911", Toast.LENGTH_LONG).show();
                        break;
                    case "Vina":
                        Toast.makeText(getApplicationContext(), "08133262972", Toast.LENGTH_LONG).show();
                        break;
                    case "Gita":
                        Toast.makeText(getApplicationContext(), "08112333444", Toast.LENGTH_LONG).show();
                        break;
                    case "Luthfi":
                        Toast.makeText(getApplicationContext(), "08165242722", Toast.LENGTH_LONG).show();
                        break;
                    case "Vian":
                        Toast.makeText(getApplicationContext(), "08162426288", Toast.LENGTH_LONG).show();
                        break;
                }

        }
        return false;
    }

    // Menu Search
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)) {
                    adapter.filter("");
                    list.clearTextFilter();
                } else {
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }
}