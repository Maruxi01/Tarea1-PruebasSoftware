package com.example.tarea1.controllers;

import com.example.tarea1.models.Auto;
import com.example.tarea1.services.AutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final AutoService autoService;

    public ContactController(AutoService autoService) {
        this.autoService = autoService;
    }
    /**
     * This method contact the agency and add 1 to the popularity of the car that is contacting
     * @param id_auto the id of the car that is contacting
     * @return the car that is contacting
     * **/
    @GetMapping("/{id_auto}")
    public ResponseEntity<Auto> contactAgency(@PathVariable int id_auto){

        Auto auto = autoService.getAutoById(id_auto);
        auto.incrementPopularidad();
        autoService.saveAuto(auto);

        return ResponseEntity.ok(auto);
    }
}
