package com.example.tarea1.services;

import com.example.tarea1.DAO.AutoRepository;
import com.example.tarea1.models.Auto;
import com.example.tarea1.models.literalConstants.COLOR;
import com.example.tarea1.models.literalConstants.TIPO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {
    AutoRepository autoRepository;

    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    /**
     * This method save an auto in the database
     * @param auto the auto to save
     * @return the auto saved
     * */
    public Auto saveAuto(Auto auto) {
        return autoRepository.save(auto);
    }


    /**
     * This method find all autos by a specific price
     * @param precio the price to filter
     * @return the list of autos filtered
     * **/
    public List<Auto> findByPrice(Integer precio) {
        return autoRepository.filterByPrecio(precio);
    }
    /**
     * This method find all autos by a specific type
     * @param tipo the type to filter
     * @return the list of autos filtered
     * **/
    public List<Auto> findByType(TIPO tipo) {
        return autoRepository.filterByTipo(tipo);
    }

    /**
     * This method find all autos by a specific color
     * @param color the color to filter
     * @return the list of autos filtered
     * **/
    public List<Auto> findByColor(COLOR color) {
        return autoRepository.filterByColor(color);
    }

    /**
     * This method find all autos in the database
     * @return the list of autos
     * */
    public List<Auto> getAllAutos(){
        return autoRepository.findAll();
    }

    /**
     * This method find an auto by id
     * @param id the id of the auto
     * @return the auto found
     * **/
    public Auto getAutoById(int id){
        return autoRepository.findById((long) id).orElse(null);
    }
}
