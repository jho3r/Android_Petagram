package com.jho3r.petagram.pojo;

import java.util.Random;

public class Mascota {

    private int imagen;
    private String nombre;
    private int rating;
    private int numeroFotos;
    private static Random mRandom = new Random();
    private int[] ratings;

    public Mascota(int imagen, String nombre, int rating, int numeroFotos) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.rating = rating;
        this.numeroFotos = numeroFotos;
        ratings = crearArreglo(numeroFotos);
    }

    private final int[] crearArreglo(int a){
        int[] ratings2 = new int[a];
        for (int i=0;i<a;i++){
            ratings2[i] = mRandom.nextInt(50);
        }
        return ratings2;
    }

    public int getRatingFoto(int indice) {
        return ratings[indice];
    }

    public int getNumeroFotos() {
        return numeroFotos;
    }

    public void setNumeroFotos(int numeroFotos) {
        this.numeroFotos = numeroFotos;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void rate(){
        this.rating ++;
    }


}
