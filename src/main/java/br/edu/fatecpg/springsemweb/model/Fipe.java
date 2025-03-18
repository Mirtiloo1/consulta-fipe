package br.edu.fatecpg.springsemweb.model;

public class Fipe {
    public String Marca;
    public String Modelo;
    public String AnoModelo;

    @Override
    public String toString() {
        return "Fipe{" +
                "Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                ", AnoModelo='" + AnoModelo + '\'' +
                '}';
    }
}


