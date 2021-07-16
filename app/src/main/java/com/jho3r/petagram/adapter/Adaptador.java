package com.jho3r.petagram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.jho3r.petagram.DetalleContacto;
import com.jho3r.petagram.pojo.Mascota;
import com.jho3r.petagram.R;

public class Adaptador extends RecyclerView.Adapter<Adaptador.AdaptadorViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity contexto;

    public Adaptador(ArrayList<Mascota> mascotas, Activity contexto){
        this.mascotas = mascotas;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public AdaptadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewmascota,parent,false);
        return new AdaptadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.ivFotoPet.setImageResource(mascota.getImagen());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRating.setText(String.valueOf(mascota.getRating()));

        holder.btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.rate();
                holder.tvRating.setText(String.valueOf(mascota.getRating()));
            }
        });

        holder.ivFotoPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(contexto, DetalleContacto.class);
                intent.putExtra("Posicion",position);
                contexto.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class AdaptadorViewHolder extends RecyclerView.ViewHolder{

        ImageView ivFotoPet;
        ImageButton btnRate;
        TextView tvNombre;
        TextView tvRating;
        ImageView ivBone;


        public AdaptadorViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoPet   = itemView.findViewById(R.id.ivFotoPet);
            btnRate     = itemView.findViewById(R.id.btnRate);
            tvNombre    = itemView.findViewById(R.id.tvNombre);
            tvRating    = itemView.findViewById(R.id.tvRating);
            ivBone      = itemView.findViewById(R.id.ivBone);
        }
    }

}
