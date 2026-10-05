package com.example.dogslovers;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import com.bumptech.glide.Glide;

public class Adapter extends  RecyclerView.Adapter<Adapter.MyViewHolder> {

    private ArrayList<Cachorro> list;

    private OnItemClickListener listener;

    public Adapter(ArrayList<Cachorro> list,
                   OnItemClickListener listener) {

        this.list = list;
        this.listener = listener;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onItemLongClick(int position);
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtNome.setText(list.get(position).getNome());
        holder.txtInfo.setText(list.get(position).getDescricao());
        Glide.with(holder.itemView.getContext()).load(list.get(position).getImagem()).into(holder.imgAvatar);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView txtNome;
        TextView txtInfo;
        ImageView imgAvatar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtInfo = itemView.findViewById(R.id.txtInfo);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {

                        int position = getAbsoluteAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (listener != null) {

                        int position = getAbsoluteAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemLongClick(position);
                            return true;
                        }
                    }

                    return false;
                }
            });


        }
    }

}
