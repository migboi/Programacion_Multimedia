package com.example.ejercicoreco2;

import java.io.Serializable;

public class paquete implements Serializable {

    private String zona;
    private String tarifa;
    private String tipo;
    private String peso;
    private double precio;


    public paquete(String zona, String tarifa, String tipo, String peso, Double precio) {
        this.zona = zona;
        this.tarifa = tarifa;
        this.tipo = tipo;
        this.peso = peso;
        this.precio = precio;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  zona + " "+tarifa + " "+ tipo +" "+  peso +" "+precio;
    }
}
