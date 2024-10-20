package com.example.testefx;

public class Item {

    private final String nome;
    private final String modelo;
    private final Float serie;

    public Item (String nome, String modelo, Float serie){
      this.nome = nome;
      this.modelo = modelo;
      this.serie = serie;
    };

    public String getModelo() {
        return modelo;
    }

    public String getNome() {
        return nome;
    }

    public Float getSerie() {
        return serie;
    }
}
