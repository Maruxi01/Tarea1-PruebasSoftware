package com.example.tarea1.utils;

import com.example.tarea1.models.Auto;
import com.example.tarea1.models.literalConstants.TIPO_USER;
import com.example.tarea1.services.AutoService;

import java.util.List;

public class IncrementPopularity {

    private AutoService autoService = null;

    public IncrementPopularity(AutoService autoService) {
        this.autoService = autoService;
    }
    /**
     * This method increment the popularity of the cars in an array
     * @param autosArr the array of cars
     * @param tipoUser the type of user that is filtering the cars
     * **/
    public void incrementPopularity(List<Auto> autosArr, TIPO_USER tipoUser){
        if (tipoUser== TIPO_USER.Agent){
            for (Auto auto: autosArr){
                auto.incrementPopularidad();
                autoService.saveAuto(auto);
            }
        }
    }
}
