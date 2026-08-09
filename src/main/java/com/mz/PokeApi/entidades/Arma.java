package com.mz.PokeApi.entidades;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Arma{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private int Bonificadordano;
    private float peso;
    
    @ManyToMany(mappedBy = "armas")
    private List<Peleador> peleadores;

    public Arma(long id, String nombre, int Bonificadordano, float peso) {
        this.id = id;
        this.nombre = nombre;
        this.Bonificadordano = Bonificadordano;
        this.peso = peso;
    }
    
    public Arma() {
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
    public int getBonificadordano() {
        return Bonificadordano;
    }
    public void setBonificadordano(int Bonificadordano) {
        this.Bonificadordano = Bonificadordano;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
}
