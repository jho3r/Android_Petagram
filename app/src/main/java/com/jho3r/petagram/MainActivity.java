package com.jho3r.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.jho3r.petagram.adapter.Adaptador;
import com.jho3r.petagram.adapter.PageAdapter;
import com.jho3r.petagram.fragment.PerfilFragment;
import com.jho3r.petagram.fragment.RecyclerViewFragment;
import com.jho3r.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager vpContenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        vpContenedor = findViewById(R.id.vpContenedor);

        setUpViewPager();
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        vpContenedor.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(vpContenedor);
        tabLayout.getTabAt(0).setIcon(R.drawable.pets);
        tabLayout.getTabAt(1).setIcon(R.drawable.paw);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mContacto:
                Intent intent = new Intent(this,Contacto.class);
                startActivity(intent);
                break;
            case R.id.mAcerca:
                Intent intent3 = new Intent(this,About.class);
                startActivity(intent3);
                break;
            case R.id.action_favoritos:
                Intent intent2 = new Intent(this,Favoritos.class);
                startActivity(intent2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.opciones,menu);
        return true;
    }
}