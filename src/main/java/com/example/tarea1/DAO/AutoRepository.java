package com.example.tarea1.DAO;

import com.example.tarea1.models.Auto;
import com.example.tarea1.models.literalConstants.COLOR;
import com.example.tarea1.models.literalConstants.TIPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Long> {

        @Query("SELECT auto FROM Auto auto WHERE auto.precio <= :precio")
        List<Auto> filterByPrecio(@Param("precio") Integer precio);

        @Query("SELECT auto FROM Auto auto WHERE auto.tipo = :tipo")
        List<Auto> filterByTipo(@Param("tipo") TIPO tipo);

        @Query("SELECT auto FROM Auto auto WHERE auto.color = :color")
        List<Auto> filterByColor(@Param("color") COLOR color);



}
