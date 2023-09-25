package com.example.tarea1.models;

import com.example.tarea1.models.literalConstants.COLOR;
import com.example.tarea1.models.literalConstants.MARCA;
import com.example.tarea1.models.literalConstants.TIPO;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "auto")
public class Auto {
    @Id
    @Column(name = "id", nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private MARCA marca;
    private int anio;
    @Enumerated(EnumType.STRING)
    private COLOR color;
    private Integer precio;
    private boolean tieneTurbo;
    @Enumerated(EnumType.STRING)
    private TIPO tipo;
    private String motor;
    @Column(nullable = true)
    private String cabinas;
    @Column(nullable = true)
    private boolean tieneSunroof;
    @Column(nullable = true)
    private int popularidad = 0;

    public void incrementPopularidad(){
        this.popularidad++;
    }

    @Override
    public String toString() {
        return "El Auto n°" + id +  "tiene las siguientes caracteristicas" + '\'' +
                "marca='" + marca + '\'' +
                "año" + anio + '\'' +
                "color=" + color + '\'' +
                "precio=" + precio +'\'' +
                "tieneTurbo=" + tieneTurbo +'\'' +
                "tipo=" + tipo +'\'' +
                "motor='" + motor + '\'' +
                "cabinas='" + cabinas + '\'' +
                "tieneSunroof=" + tieneSunroof +'\'' +
                '\'';
    }
}
