package com.example.testSeratic.models;


import java.util.HashSet;
import java.util.Set;

public class Tipo  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private Set boletos = new HashSet(0);

    public Tipo() {
    }

	
    public Tipo(String nombre) {
        this.nombre = nombre;
    }
    public Tipo(String nombre, Set boletos) {
       this.nombre = nombre;
       this.boletos = boletos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getBoletos() {
        return this.boletos;
    }
    
    public void setBoletos(Set boletos) {
        this.boletos = boletos;
    }




}


