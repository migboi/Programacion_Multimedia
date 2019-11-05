package com.example.ejerciciorecopilatorio;

import java.io.Serializable;

public class Regalo implements Serializable {

    private String Zona;
    private String tarifa;
    private String tipo;
    private int peso;
    private double precio;

    public Regalo(String zona, String tarifa, String tipo, int peso, double precio) {
        Zona = zona;
        this.tarifa = tarifa;
        this.tipo = tipo;
        this.peso = peso;
        this.precio = precio;
    }


    public String getZona() {
        return Zona;
    }

    public void setZona(String zona) {
        Zona = zona;
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

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Regalo{" +
                "Zona='" + Zona + '\'' +
                ", tarifa='" + tarifa + '\'' +
                ", tipo='" + tipo + '\'' +
                ", peso=" + peso +
                ", precio=" + precio +
                '}';
    }
}
