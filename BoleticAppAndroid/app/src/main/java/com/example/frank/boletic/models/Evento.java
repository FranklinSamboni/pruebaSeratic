package com.example.frank.boletic.models;

import com.google.gson.JsonObject;

import java.security.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by FRANK on 2/09/2017.
 */

public class Evento {

    private int id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private Date fecha;
    private int cantidadBoletos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fecha=" + fecha +
                ", cantidadBoletos=" + cantidadBoletos +
                '}';
    }

    public static Evento getEventoFromJSON(JsonObject jsonObject){

        Evento evento = new Evento();

        evento.setId(jsonObject.get("id").getAsInt());
        evento.setNombre(jsonObject.get("nombre").getAsString());
        evento.setDireccion(jsonObject.get("direccion").getAsString());
        evento.setCiudad(jsonObject.get("ciudad").getAsString());

        Date dt = new Date(jsonObject.get("fecha").getAsLong());

        evento.setFecha(dt);


        evento.setCantidadBoletos(jsonObject.get("cantidadBoletos").getAsInt());

        return evento;
    }


}
