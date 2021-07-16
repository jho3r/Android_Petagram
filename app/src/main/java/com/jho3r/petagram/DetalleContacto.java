package com.jho3r.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jho3r.petagram.adapter.AdaptadorFotos;
import com.jho3r.petagram.fragment.RecyclerViewFragment;
import com.jho3r.petagram.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

public class DetalleContacto extends AppCompatActivity {

    private int posicion;
    private Mascota mMascota;
    private TextView tvNombre;
    private TextView tvRating;
    private CircularImageView ivFoto;
    private RecyclerView rvFotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_perfil);

        Bundle extras = getIntent().getExtras();
        posicion = extras.getInt("Posicion");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mMascota = RecyclerViewFragment.mascotas.get(posicion);

        tvNombre = findViewById(R.id.tvMyPetName);
        tvRating = findViewById(R.id.tvPetRating);
        ivFoto = findViewById(R.id.circularImageView);

        tvNombre.setText(mMascota.getNombre());
        tvRating.setText(String.valueOf(mMascota.getRating()));
        ivFoto.setImageResource(mMascota.getImagen());

        rvFotos = findViewById(R.id.rvFotos);
        GridLayoutManager glm = new GridLayoutManager(getApplicationContext(),2);
        rvFotos.setLayoutManager(glm);

        AdaptadorFotos adaptadorFotos = new AdaptadorFotos(mMascota);
        rvFotos.setAdapter(adaptadorFotos);
    }
}