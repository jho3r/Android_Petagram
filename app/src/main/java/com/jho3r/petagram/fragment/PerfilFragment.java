package com.jho3r.petagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jho3r.petagram.R;
import com.jho3r.petagram.adapter.Adaptador;
import com.jho3r.petagram.adapter.AdaptadorFotos;
import com.jho3r.petagram.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PerfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PerfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PerfilFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_perfil, container, false);

        RecyclerView rvFotos = v.findViewById(R.id.rvFotos);
        TextView tvNombre = v.findViewById(R.id.tvMyPetName);
        TextView tvPetRating = v.findViewById(R.id.tvPetRating);
        CircularImageView ivFoto= v.findViewById(R.id.circularImageView);

        Mascota miMascota = new Mascota(R.drawable.mypet,"Buck",10,5);

        tvNombre.setText(miMascota.getNombre());
        tvPetRating.setText(String.valueOf(miMascota.getRating()));
        ivFoto.setImageResource(miMascota.getImagen());

        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        rvFotos.setLayoutManager(glm);

        AdaptadorFotos adaptadorFotos = new AdaptadorFotos(miMascota);
        rvFotos.setAdapter(adaptadorFotos);

        return v;
    }
}