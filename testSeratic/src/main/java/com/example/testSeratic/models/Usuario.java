package com.example.testSeratic.models;



public class Usuario  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String apellido;
     private String usuario;
     private String clave;
     private String telefono;
     private String fechaRegistro;
     private boolean habilitado;

    public Usuario() {
    }

	
    public Usuario(String usuario, String clave, String telefono, boolean habilitado) {
        this.usuario = usuario;
        this.clave = clave;
        this.telefono = telefono;
        this.habilitado = habilitado;
    }
    public Usuario(String nombre, String apellido, String usuario, String clave, String telefono, String fechaRegistro, boolean habilitado) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.usuario = usuario;
       this.clave = clave;
       this.telefono = telefono;
       this.fechaRegistro = fechaRegistro;
       this.habilitado = habilitado;
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
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public boolean isHabilitado() {
        return this.habilitado;
    }
    
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }




}


