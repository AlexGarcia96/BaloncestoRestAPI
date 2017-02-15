package com.example.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private LocalDate nacimiento;
    private int canastasTotales;
    private int rebotesTotales;
    private int asistenciasTotales;
    private String posicion;
    @ManyToOne
    private Equipo owner;

    public Jugador(String nombre, String posicion, int rebotesTotales, int canastasTotales, int asistenciasTotales, LocalDate nacimiento) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.rebotesTotales = rebotesTotales;
        this.canastasTotales = canastasTotales;
        this.asistenciasTotales = asistenciasTotales;
        this.nacimiento = nacimiento;


    }

    public Jugador() {
    }

    public Equipo getOwner() {
        return owner;
    }

    public void setOwner(Equipo owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getCanastasTotales() {
        return canastasTotales;
    }

    public void setCanastasTotales(int canastasTotales) {
        this.canastasTotales = canastasTotales;
    }

    public int getRebotesTotales() {
        return rebotesTotales;
    }

    public void setRebotesTotales(int rebotesTotales) {
        this.rebotesTotales = rebotesTotales;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getAsistenciasTotales() {
        return asistenciasTotales;
    }

    public void setAsistenciasTotales(int asistenciasTotales) {
        this.asistenciasTotales = asistenciasTotales;
    }
}
