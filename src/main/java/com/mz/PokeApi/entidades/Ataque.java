package com.mz.PokeApi.entidades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@Entity
public class Ataque{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private int costoEnergia;
    private int danioBase;

    @ManyToMany(mappedBy = "ataques")
    private List<Peleador> peleadores;

    public Ataque(long id, String nombre, int costoEnergia, int danioBase) {
        this.id = id;
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.danioBase = danioBase;
    }

    public Ataque() {
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

    public int getCostoEnergia() {
        return costoEnergia;
    }

    public void setCostoEnergia(int costoEnergia) {
        this.costoEnergia = costoEnergia;
    }

    public int getDanioBase() {
        return danioBase;
    }

    public void setDanioBase(int danioBase) {
        this.danioBase = danioBase;
    }
}
