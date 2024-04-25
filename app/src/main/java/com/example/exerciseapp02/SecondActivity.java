package com.example.exerciseapp02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);


            String fruitName = getIntent().getStringExtra("nome_fruta");
            int imageResId = getIntent().getIntExtra("imagem_res_id", 0);

            // Configure os elementos da segunda activity com os dados da fruta
            TextView textView = findViewById(R.id.text_title);
            textView.setText(fruitName);
            ImageView imageView = findViewById(R.id.image_detalis);
            imageView.setImageResource(imageResId);
            Button backButton = findViewById(R.id.btn_back);

            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Fechar a segunda activity e retornar para a primeira activity
                    finish();
                }
            });
            return insets;
        });
    }
}