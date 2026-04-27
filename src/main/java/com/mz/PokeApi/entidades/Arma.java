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

    public Arma(long id, String nombre, int bonificadordano, float peso) {
        this.id = id;
        this.nombre = nombre;
        Bonificadordano = bonificadordano;
        this.peso = peso;
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
    public void setBonificadordano(int bonificadordano) {
        Bonificadordano = bonificadordano;
    }
    public float getPeso() {
        return peso;
    }
    public void setPeso(float peso) {
        this.peso = peso;
    }
    public void imprimir(){
        System.out.println("Arma: " + nombre);
        System.out.println("Bonificación de daño: " + Bonificadordano);
        System.out.println("Peso: " + peso);
    }
}
