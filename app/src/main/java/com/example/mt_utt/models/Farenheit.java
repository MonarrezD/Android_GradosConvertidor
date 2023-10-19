package com.example.mt_utt.models;

public class Farenheit extends Grado{

    public Farenheit(Double valor){
        this.setValor(valor);
        this.setUnidad("F");
    }

        public Farenheit parse(Kelvin K){
            Double valor = (K.getValor() -32) * 5/9 + 273.15;
            return new Farenheit(valor);
        }

        public Farenheit parse(Celsius C){
            Double valor = (C.getValor() -32) * 5/9;
            return new Farenheit(valor);
        }
}
