package com.example.tarea1.controllers;

import com.example.tarea1.models.Auto;
import com.example.tarea1.services.AutoService;
import com.example.tarea1.utils.GenerateFeature;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/generateAuto")
public class GenerateAuto {
    private final AutoService autoService;

    public GenerateAuto( AutoService autoService) {
        this.autoService = autoService;
    }
/**
 * This method generates a random number of cars and saves them in the database
 * @param num_autos number of cars to generate
 * @return the list of cars generated
 * **/
    @GetMapping("{num_autos}")
    public ResponseEntity<ArrayList<Auto>>  generateAuto(@PathVariable int num_autos) {
        ArrayList<Auto> autos = new ArrayList<Auto>();

        for (int i = 0; i < num_autos; i++) {
            Auto auto = GenerateFeature.generateAllFeatures();

            autos.add(auto);
            autoService.saveAuto(auto);
        }
        return ResponseEntity.ok(autos);
    }
}
