package com.example.testSeratic.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Evento  implements java.io.Serializable {


     private int id;
     private String nombre;
     private String direccion;
     private String ciudad;
     private Date fecha;
     private int cantidadBoletos;
     @JsonIgnore
     private Set boletos = new HashSet(0);

    public Evento() {
    }

	
    public Evento(int id, String nombre, String direccion, String ciudad, Date fecha, int cantidadBoletos) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.cantidadBoletos = cantidadBoletos;
    }
    public Evento(int id, String nombre, String direccion, String ciudad, Date fecha, int cantidadBoletos, Set boletos) {
       this.id = id;
       this.nombre = nombre;
       this.direccion = direccion;
       this.ciudad = ciudad;
       this.fecha = fecha;
       this.cantidadBoletos = cantidadBoletos;
       this.boletos = boletos;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getCantidadBoletos() {
        return this.cantidadBoletos;
    }
    
    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }
    public Set getBoletos() {
        return this.boletos;
    }
    
    public void setBoletos(Set boletos) {
        this.boletos = boletos;
    }




}


