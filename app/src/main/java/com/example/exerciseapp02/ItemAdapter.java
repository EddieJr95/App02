package com.example.exerciseapp02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private ArrayList<ItemModel> list;

    public ItemAdapter(ArrayList<ItemModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Aqui você inflaria o layout do item e criaria uma instância de ItemViewHolder
        // para manter uma referência aos elementos dentro do item.
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemModel item = list.get(position);
        holder.textView.setText(item.getName());
        holder.imageView.setImageResource(item.getImageResId());

        // Configurar o clique do item
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Exibir o Toast com o nome do item clicado
                Toast.makeText(v.getContext(), "Clicou em " + item.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtenha os dados da fruta correspondente ao item atual

                // Inicie a próxima activity e passe os dados da fruta como extras
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra("nome_fruta", item.getName());
                intent.putExtra("imagem_res_id", item.getImageResId());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // Aqui retorna o número total de itens na lista.
        return list.size();
    }

    // Classe ViewHolder para manter referências aos elementos dentro do item.
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        Button btnDetails;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            // Aqui você inicializa os elementos dentro do item.
            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.image_view);
            btnDetails = itemView.findViewById(R.id.btn_details);
        }
    }
}
