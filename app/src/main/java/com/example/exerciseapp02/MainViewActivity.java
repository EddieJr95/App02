package com.example.exerciseapp02;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainViewActivity extends AppCompatActivity {

    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            ArrayList<ItemModel> list = new ArrayList<>();
            list.addAll(Arrays.asList(
                    new ItemModel("Maçã", R.drawable.fruta1),
                    new ItemModel("Banana", R.drawable.fruta2),
                    new ItemModel("Pêra", R.drawable.fruta3),
                    new ItemModel("Laranja", R.drawable.fruta4),
                    new ItemModel("Uva", R.drawable.fruta5),
                    new ItemModel("Morango", R.drawable.fruta6),
                    new ItemModel("Limão", R.drawable.fruta7),
                    new ItemModel("Melancia", R.drawable.fruta8),
                    new ItemModel("Abacate", R.drawable.fruta9),
                    new ItemModel("Mamão", R.drawable.fruta10)
            ));
            rvList = findViewById(R.id.rv_list);
            rvList.setAdapter(new ItemAdapter(list));
            rvList.setLayoutManager(new LinearLayoutManager(this));
            return insets;
        });
    }
}