package com.example.frank.boletic.models;

import com.google.gson.JsonObject;

/**
 * Created by FRANK on 2/09/2017.
 */

public class Usuario {

    private Integer id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String telefono;
    private String clave;
    private boolean isHabilitado;

    public boolean isHabilitado() {
        return isHabilitado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setHabilitado(boolean habilitado) {
        isHabilitado = habilitado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", usuario='" + usuario + '\'' +
                ", telefono='" + telefono + '\'' +
                ", isHabilitado='" + isHabilitado + '\'' +
                '}';
    }

    public static Usuario getUserFromJSON(JsonObject jsonObject){

        Usuario user = new Usuario();

        user.setId(jsonObject.get("id").getAsInt());
        user.setNombre(jsonObject.get("nombre").getAsString());
        user.setApellido(jsonObject.get("apellido").getAsString());
        user.setUsuario(jsonObject.get("usuario").getAsString());
        user.setTelefono(jsonObject.get("telefono").getAsString());
        user.setHabilitado(jsonObject.get("habilitado").getAsBoolean());

        return user;
    }


}
