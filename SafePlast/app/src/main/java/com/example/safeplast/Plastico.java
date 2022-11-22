package com.example.safeplast;

import java.util.ArrayList;

public class Plastico {
    private String nombre;
    private int cantidad;
    private String color;

    public static ArrayList<Plastico> consumo;

    Plastico(String n, int cant, String c){
        this.nombre = n;
        this.cantidad=cant;
        this.color = c;
    }

    //Accesores
    public String getNombre(){
        return nombre;
    }

    public float getCantidad() {
        return cantidad;
    }

    public String getColor() {
        return color;
    }

    public static void generarConsumPlasticoBeta(){

        consumo = new ArrayList<Plastico>();

        consumo.add(new Plastico("PET", 72,"#2ba9ca"));
        consumo.add(new Plastico("HDPE", 37,"#23afa0"));
        consumo.add(new Plastico("PVC", 17,"#9ee0a9"));
        consumo.add(new Plastico("LDPE", 12,"#e5e5bb"));
        consumo.add(new Plastico("PP", 13,"#0c412e"));
        consumo.add(new Plastico("PS", 13,"#377057"));
        consumo.add(new Plastico("O", 41,"#749576"));

    }
}
