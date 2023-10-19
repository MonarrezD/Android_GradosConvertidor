package com.example.mt_utt.models;

public class Celsius extends Grado{

    public Celsius(Double valor) {
        this.setValor(valor);
        this.setUnidad("C");
    }

        public Celsius parse(Farenheit F){
            Double valor = (F.getValor() *9/5) + 32;
            return new Celsius(valor);

        }

        //conversión a kelvin
        public Celsius parse(Kelvin K) {
            Double valor = this.getValor() + 273.15;
            return new Celsius(valor);
        }
}
