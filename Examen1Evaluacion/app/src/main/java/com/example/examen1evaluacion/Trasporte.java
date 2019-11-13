package com.example.examen1evaluacion;

import java.io.Serializable;

public class Trasporte implements Serializable {


    private String trasporte;
    private String seguro;
    private  String extra;
    private String precio;


    public Trasporte(String trasporte, String seguro, String extra, String precio) {
        this.trasporte = trasporte;
        this.seguro = seguro;
        this.extra = extra;
        this.precio = precio;
    }


    public String getTrasporte() {
        return trasporte;
    }

    public void setTrasporte(String trasporte) {
        this.trasporte = trasporte;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return trasporte +" "+ seguro+" " + extra+" " + precio+" €" ;
    }
}
