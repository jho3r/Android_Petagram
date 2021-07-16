package com.jho3r.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.jho3r.petagram.adapter.Adaptador;
import com.jho3r.petagram.pojo.Mascota;

import java.util.ArrayList;

public class Favoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
    RecyclerView rvFavoritos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        agregarMascotas();

        rvFavoritos = findViewById(R.id.rvFavoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvFavoritos.setLayoutManager(llm);


        inicializarAdaptador();



    }

    public void inicializarAdaptador(){
        Adaptador adaptador = new Adaptador(mascotas,this);
        rvFavoritos.setAdapter(adaptador);
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
}