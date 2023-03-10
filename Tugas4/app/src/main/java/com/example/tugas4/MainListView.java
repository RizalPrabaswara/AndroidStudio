package com.example.tugas4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainListView extends AppCompatActivity {
    private RecyclerView menulist;
    ArrayList<Listmenuview> listdatamenuview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view);
        menulist = (RecyclerView)findViewById(R.id.isiList);
        listdatamenuview = new ArrayList<>();
        listdatamenuview.add(new Listmenuview("C++ For Beginner","2016",R.drawable.c1));
        listdatamenuview.add(new Listmenuview("C ++ For Beginner Part 2","2017",R.drawable.c2));
        listdatamenuview.add(new Listmenuview("C++ For Expert","2016",R.drawable.c3));
        listdatamenuview.add(new Listmenuview("Tips & Trick C++","2019",R.drawable.c4));
        listdatamenuview.add(new Listmenuview("Belajar Laravel Mudah","2020",R.drawable.laravel1));
        listdatamenuview.add(new Listmenuview("Laravel For Beginner","2018",R.drawable.laravel2));
        listdatamenuview.add(new Listmenuview("Laravel For Beginner Part 2","2017",R.drawable.laravel3));
        listdatamenuview.add(new Listmenuview("Tips & Trick Laravel","2017",R.drawable.laravel4));
        listdatamenuview.add(new Listmenuview("Phython For Beginner","2017",R.drawable.phython1));
        listdatamenuview.add(new Listmenuview("Phyton For Expert","2018",R.drawable.phython2));
        listdatamenuview.add(new Listmenuview("Tutorial Phython part 1","2019",R.drawable.phython3));
        listdatamenuview.add(new Listmenuview("Tutorial Phython part 2","2020",R.drawable.phython4));
        listdatamenuview.add(new Listmenuview("PHP For Beginner","2020",R.drawable.php1));
        listdatamenuview.add(new Listmenuview("PHP For Expert","2018",R.drawable.php2));
        listdatamenuview.add(new Listmenuview("Tips & Trick PHP","2016",R.drawable.php3));
        listdatamenuview.add(new Listmenuview("PHP Project","2019",R.drawable.php4));

        IsiAdapterListView adapterListView = new IsiAdapterListView(listdatamenuview);
        RecyclerView.LayoutManager layoutmanagerlistview;
        layoutmanagerlistview = new LinearLayoutManager(getApplicationContext());
        menulist.setLayoutManager(layoutmanagerlistview);
        menulist.setAdapter(adapterListView);
    }
}