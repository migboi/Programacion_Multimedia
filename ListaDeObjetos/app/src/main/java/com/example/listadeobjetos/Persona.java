package com.example.listadeobjetos;

import java.io.Serializable;

public class Persona  implements Serializable {

    private String nombre;
    private String apellido;
    private int edad;
    private String pais;


    public Persona(String nombre, String apellido, int edad, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return  nombre + " "+ apellido + " " + edad +" "+ pais;
    }
}
