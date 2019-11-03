package com.example.spinnerobjetos;

public class MiModelo {
    private int valor;
    private String texto;

    public MiModelo(int valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return valor +" " +texto ;
    }
}
