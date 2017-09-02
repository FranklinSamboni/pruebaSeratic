package com.example.testSeratic.models;



public class Reserva  implements java.io.Serializable {


     private Integer id;
     private Boleto boleto;
     private Cliente cliente;
     private String fechaCreacion;

    public Reserva() {
    }

    public Reserva(Boleto boleto, Cliente cliente, String fechaCreacion) {
       this.boleto = boleto;
       this.cliente = cliente;
       this.fechaCreacion = fechaCreacion;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Boleto getBoleto() {
        return this.boleto;
    }
    
    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }




}


