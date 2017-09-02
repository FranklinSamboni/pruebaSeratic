package com.example.testSeratic.models;


import java.util.HashSet;
import java.util.Set;


public class Cliente  implements java.io.Serializable {


     private Integer id;
     private String cedula;
     private String nombre;
     private String telefono;
     private String correo;
     private Set reservas = new HashSet(0);

    public Cliente() {
    }

	
    public Cliente(String cedula, String nombre, String telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public Cliente(String cedula, String nombre, String telefono, String correo, Set reservas) {
       this.cedula = cedula;
       this.nombre = nombre;
       this.telefono = telefono;
       this.correo = correo;
       this.reservas = reservas;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public Set getReservas() {
        return this.reservas;
    }
    
    public void setReservas(Set reservas) {
        this.reservas = reservas;
    }




}


