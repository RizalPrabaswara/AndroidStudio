package com.example.tugas4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IsiAdapterMenu.RecyclerViewClickListener {
    private RecyclerView menu,background;
    private ArrayList<Listmenu> listdatamenu;
    private ArrayList<Listbackground> listdatabackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        background = (RecyclerView)findViewById(R.id.gambarbackground);
        listdatabackground=new ArrayList<>();
        listdatabackground.add(new Listbackground(R.drawable.bg));
        listdatabackground.add(new Listbackground(R.drawable.logo1));
        listdatabackground.add(new Listbackground(R.drawable.logo2));
        listdatabackground.add(new Listbackground(R.drawable.logo3));
        menu =(RecyclerView)findViewById(R.id.menugrid);
        listdatamenu=new ArrayList<Listmenu>();
        listdatamenu.add(new Listmenu("C#","Easy",R.drawable.logo1));
        listdatamenu.add(new Listmenu("Laravel","Hard",R.drawable.logo2));
        listdatamenu.add(new Listmenu("Phython","Medium",R.drawable.logo3));
        listdatamenu.add(new Listmenu("PHP","Hard",R.drawable.logo4));
        listdatamenu.add(new Listmenu("Visual Studio","Easy",R.drawable.logo5));
        listdatamenu.add(new Listmenu("C++","Medium",R.drawable.logo6));
        listdatamenu.add(new Listmenu("C#","Easy",R.drawable.logo1));
        listdatamenu.add(new Listmenu("Laravel","Hard",R.drawable.logo2));
        listdatamenu.add(new Listmenu("Phython","Medium",R.drawable.logo3));
        listdatamenu.add(new Listmenu("PHP","Hard",R.drawable.logo4));
        listdatamenu.add(new Listmenu("Visual Studio","Easy",R.drawable.logo5));
        listdatamenu.add(new Listmenu("C++","Medium",R.drawable.logo6));
        listdatamenu.add(new Listmenu("C#","Easy",R.drawable.logo1));
        listdatamenu.add(new Listmenu("Laravel","Hard",R.drawable.logo2));
        listdatamenu.add(new Listmenu("Phython","Medium",R.drawable.logo3));
        listdatamenu.add(new Listmenu("PHP","Hard",R.drawable.logo4));
        listdatamenu.add(new Listmenu("Visual Studio","Easy",R.drawable.logo5));
        listdatamenu.add(new Listmenu("C++","Medium",R.drawable.logo6));

        IsiAdapterbackground adapterbackground = new IsiAdapterbackground(listdatabackground);
        IsiAdapterMenu adaptermenu = new IsiAdapterMenu(listdatamenu, this);
        RecyclerView.LayoutManager layoutmanagerbackground;
        RecyclerView.LayoutManager layoutmanagermenu;
        layoutmanagerbackground = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
        layoutmanagermenu=new GridLayoutManager(getApplicationContext(),3);
        background.setLayoutManager(layoutmanagerbackground);
        background.setAdapter(adapterbackground);
        menu.setLayoutManager(layoutmanagermenu);
        menu.setAdapter(adaptermenu);
    }

    @Override
    public void OnClick(int position) {
        listdatamenu.get(position);
        Intent lanjut = new Intent(this,MainListView.class);
        startActivity(lanjut);
    }
}