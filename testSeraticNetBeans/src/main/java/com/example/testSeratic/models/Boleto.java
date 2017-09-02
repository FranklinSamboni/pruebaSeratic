package com.example.testSeratic.models;


import java.util.HashSet;
import java.util.Set;


public class Boleto  implements java.io.Serializable {


     private Integer id;
     private Evento evento;
     private Tipo tipo;
     private double valor;
     private Set reservas = new HashSet(0);

    public Boleto() {
    }

	
    public Boleto(Evento evento, Tipo tipo, double valor) {
        this.evento = evento;
        this.tipo = tipo;
        this.valor = valor;
    }
    public Boleto(Evento evento, Tipo tipo, double valor, Set reservas) {
       this.evento = evento;
       this.tipo = tipo;
       this.valor = valor;
       this.reservas = reservas;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Evento getEvento() {
        return this.evento;
    }
    
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public Tipo getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public double getValor() {
        return this.valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    public Set getReservas() {
        return this.reservas;
    }
    
    public void setReservas(Set reservas) {
        this.reservas = reservas;
    }




}


