package com.example.dogslovers;

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
import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    private ImageView imgAvatar;
    private TextView textNome, textRaca, textDescricao;
    private Button btnVoltar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.actDetails), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgAvatar = findViewById(R.id.imageView4);
        textNome = findViewById(R.id.textNome);
        textRaca = findViewById(R.id.textRaca);
        textDescricao = findViewById(R.id.textDescricao);
        btnVoltar = findViewById(R.id.btnVoltar);

        String nome = getIntent().getStringExtra("nome");
        String raca = getIntent().getStringExtra("raca");
        String idade = getIntent().getStringExtra("idade");
        String descricao = getIntent().getStringExtra("descricao");
        String imagem = getIntent().getStringExtra("imagem");

        textNome.setText(nome);
        textRaca.setText(raca);
        textDescricao.setText(descricao);

        Glide.with(this).load(imagem).into(imgAvatar);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
