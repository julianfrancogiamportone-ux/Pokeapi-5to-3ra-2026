package com.mz.PokeApi.entidades;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

public class Peleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int puntosVida;
    private int energia;
    private float defensaBase;
    private String imgurl;

    @ManyToMany

    @JoinTable(name = "peleador_armas", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "arma_id"))
    private List<Arma> armas;

    @ManyToMany
    
    @JoinTable(name = "peleador_ataques", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "ataque_id"))
    private List<Ataque> ataques;

    public Peleador(Long id, String nombre, int puntosVida, int energia, float defensaBase, Arma armaEquipada,
        List<Arma> armas, List<Ataque> ataques, String imgurl) {
        this.id = id;
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.energia = energia;
        this.defensaBase = defensaBase;
        this.armas = armas;
        this.ataques = ataques;
        this.imgurl = imgurl;
    }

    public Peleador() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public float getDefensaBase() {
        return defensaBase;
    }

    public void setDefensaBase(float defensaBase) {
        this.defensaBase = defensaBase;
    }
    

    public List<Arma> getArmas() {
        return armas;
    }

    public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }
    
     public List<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }   
}
