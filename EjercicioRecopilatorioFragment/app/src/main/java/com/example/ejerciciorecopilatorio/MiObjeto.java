package com.example.ejerciciorecopilatorio;

public class MiObjeto {

    private String Zona;
    private String continente;
    private int precio;


    public MiObjeto(String zona, String continente, int precio) {
        this.Zona = zona;
        this.continente = continente;
        this.precio = precio;
    }


    public String getZona() {
        return Zona;
    }

    public void setZona(String zona) {
        Zona = zona;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  Zona+" " + continente +" " + precio +" €";
    }
}
