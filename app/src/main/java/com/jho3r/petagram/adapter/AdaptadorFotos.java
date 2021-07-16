// Adaptador para las fotos de cada mascota dentro de detalles_contacto o perfilfragment

package com.jho3r.petagram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jho3r.petagram.R;
import com.jho3r.petagram.pojo.Mascota;

public class AdaptadorFotos extends RecyclerView.Adapter<AdaptadorFotos.AdaptadorFotosViewHolder>{

    Mascota mMascota;

    public AdaptadorFotos(Mascota mMascota){
        this.mMascota = mMascota;
    }

    @NonNull
    @Override
    public AdaptadorFotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewfotosmascota,parent,false);
        return new AdaptadorFotosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorFotosViewHolder holder, int position) {
        holder.ivFoto.setImageResource(mMascota.getImagen());
        holder.rating.setText(Integer.toString(mMascota.getRatingFoto(position)));
    }

    @Override
    public int getItemCount() {
        return mMascota.getNumeroFotos();
    }

    public static class AdaptadorFotosViewHolder extends RecyclerView.ViewHolder{
        ImageView ivFoto;
        TextView rating;

        public AdaptadorFotosViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.ivFotoMyPet);
            rating = itemView.findViewById(R.id.tvFotoRating);
        }
    }

}
