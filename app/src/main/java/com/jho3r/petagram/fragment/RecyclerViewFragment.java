package com.jho3r.petagram.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jho3r.petagram.R;
import com.jho3r.petagram.adapter.Adaptador;
import com.jho3r.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    public static ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);

        mascotas = new ArrayList<Mascota>();
        agregarMascotas();

        Log.d("Petagram","Se inicio correctamente el arraylist");
        listaMascotas = v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        Log.d("Petagram","Se agrego el Layout Manager");

        inicializarAdaptador();

        return v;
    }

    private void agregarMascotas(){
        mascotas.add(new Mascota(R.drawable.pet1,"Kity",1,4));
        mascotas.add(new Mascota(R.drawable.pet2,"Rudolf",8,7));
        mascotas.add(new Mascota(R.drawable.pet3,"Spark",4,2));
        mascotas.add(new Mascota(R.drawable.pet4,"Ramon",2,5));
        mascotas.add(new Mascota(R.drawable.pet5,"Max",7,10));
        mascotas.add(new Mascota(R.drawable.pet6,"Pinker",4,1));
        mascotas.add(new Mascota(R.drawable.pet7,"Rambo",3,10));
    }

    public void inicializarAdaptador(){
        Adaptador adaptador = new Adaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }

}
