package com.example.tarea1.models;

import com.example.tarea1.models.literalConstants.TIPO_USER;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "id", nullable = false, length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private TIPO_USER tipoUser;

}
