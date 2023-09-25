package com.example.tarea1.controllers;

import com.example.tarea1.models.Auto;
import com.example.tarea1.models.literalConstants.COLOR;
import com.example.tarea1.models.literalConstants.TIPO;
import com.example.tarea1.models.literalConstants.TIPO_USER;
import com.example.tarea1.services.AutoService;
import com.example.tarea1.utils.IncrementPopularity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filterAuto")
public class FilterAuto {

    private final AutoService autoService;

    public FilterAuto(AutoService autoService) {
        this.autoService = autoService;
    }
    /**
     * This method filter the cars by price, type and color
     * @param precio the price of the car
     * @param tipo the type of the car
     * @param color the color of the car
     * @param tipoUser the type of user that is filtering the cars
     * @return the list of cars filtered
     * **/
    @GetMapping("")
    public ResponseEntity<List<Auto>> filterAutos(
            @RequestParam(name = "precio", required = false) Integer precio,
            @RequestParam(name = "tipo", required = false) TIPO tipo,
            @RequestParam(name = "color", required = false) COLOR color,
            @RequestParam(name = "user") TIPO_USER tipoUser
            ){
        IncrementPopularity incrementPopularity = new IncrementPopularity(autoService);

        List<Auto> todosAutos = autoService.getAllAutos();
        List<Auto> autosFiltrados = new ArrayList<>(todosAutos);
        List<Auto> autosAux;

        if (precio!=null){
            autosAux = autoService.findByPrice(precio);
            autosFiltrados.retainAll(autosAux);
        }

        if (tipo!=null){
            autosAux = autoService.findByType(tipo);
            autosFiltrados.retainAll(autosAux);
        }

        if (color!=null){
            autosAux = autoService.findByColor(color);
            autosFiltrados.retainAll(autosAux);
        }

        incrementPopularity.incrementPopularity(autosFiltrados, tipoUser);

        return ResponseEntity.ok(autosFiltrados);
    }

}
