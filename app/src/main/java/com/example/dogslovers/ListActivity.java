package com.example.dogslovers;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Cachorro> list;
    private Adapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.actList), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);
        list = CachorroData.getCachorros();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new Adapter(list, new Adapter.OnItemClickListener() {

            @Override
            public void onItemClick(int position) {
                Cachorro cachorro = list.get(position);

                Intent intent = new Intent(ListActivity.this, DetailsActivity.class);
                intent.putExtra("nome", cachorro.getNome());
                intent.putExtra("raca", cachorro.getRaca());
                intent.putExtra("descricao", cachorro.getDescricao());
                intent.putExtra("imagem", cachorro.getImagem());

                startActivity(intent);
            }

            @Override
            public void onItemLongClick(int position) {
                String nome = list.get(position).getNome();

                AlertDialog.Builder alerta = new AlertDialog.Builder(ListActivity.this);
                alerta.setTitle("Confirmação");
                alerta.setIcon(R.drawable.img_1);
                alerta.setMessage("Realmente deseja excluir esse Cachorro?");
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        list.remove(position);
                        adapter.notifyItemRemoved(position);
                        Toast.makeText(ListActivity.this, nome + " foi removido da lista.", Toast.LENGTH_SHORT).show();
                    }
                });
                alerta.setNegativeButton("Não", null);
                alerta.create().show();
            }
        });
            recyclerView.setAdapter(adapter);
    }

}
