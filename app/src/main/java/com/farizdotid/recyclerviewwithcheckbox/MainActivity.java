package com.farizdotid.recyclerviewwithcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> produkList;
    private RecyclerView rvListProduk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        produkList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            produkList.add("Produk " + i);
        }

        rvListProduk = (RecyclerView) findViewById(R.id.rvListProduk);
        rvListProduk.setLayoutManager(new LinearLayoutManager(this));
        rvListProduk.setAdapter(new ProdukListAdapter(this, produkList));
    }
}
