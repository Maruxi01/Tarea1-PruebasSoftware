package com.example.tarea1.utils;

import com.example.tarea1.DAO.AutoRepository;
import com.example.tarea1.models.Auto;
import com.example.tarea1.models.literalConstants.COLOR;
import com.example.tarea1.models.literalConstants.MARCA;
import com.example.tarea1.models.literalConstants.TIPO;

import java.util.ArrayList;

public class GenerateFeature {

    static Integer[] ANIOS = Constants.ANIO;
    static MARCA[] MARCAS = MARCA.values();

    static COLOR[] COLORES = COLOR.values();

    static Boolean[] TIENE_TURBO = Constants.TIENE_TURBO;

    static TIPO[] TIPOS = TIPO.values();

    static String[] MOTORES_SEDAN = Constants.MOTOR_SEDAN;
    static String[] MOTORES_CAMIONETA = Constants.MOTOR_CAMIONETA;
    static String[] MOTORES_SUV = Constants.MOTOR_SUV;
    static String[] CABINAS = Constants.NUM_CABINAS;

    static Boolean[] TIENE_SUNROOF = Constants.TIENE_SUNROOF;

    public GenerateFeature() {
    }
    /**
     * This method is used to generate a random option of a car feature,
     * giving an array with different options of a car feature
     * @param arr array of any type, which contains the different options of a car feature
     * @return a random option of the car feature
    * */
    public static <T> T generateFeature(T[] arr ) {

        int randomFeature = GenerateRandom.generateRandom(arr);
        return arr[randomFeature];
    }
/**
 * This method is used to generate a random car, with all its features
 * @return a random car, with all its features
 * **/
    public static Auto generateAllFeatures() {
        Auto auto = new Auto();

        int annio = generateFeature(ANIOS);
        MARCA marca = generateFeature(MARCAS);
        COLOR color = generateFeature(COLORES);
        Boolean tieneTurbo = generateFeature(TIENE_TURBO);
        TIPO tipo = generateFeature(TIPOS);
        Integer precio = GenerateRandom.generateRandomPrice();

        auto.setMarca(marca);
        auto.setAnio(annio);
        auto.setColor(color);
        auto.setPrecio(precio);
        auto.setTieneTurbo(tieneTurbo);
        auto.setTipo(tipo);

        Auto autoFeaturesByTipo = addFeatureByTipo(tipo, auto);

        return autoFeaturesByTipo;
    }

    /**
     * This method is used to add features to a car, depending on its type
     * @param tipo type of the car
     * @param auto car to which features will be added
     * @return a car with features by its type
     * **/
    public static Auto addFeatureByTipo(TIPO tipo, Auto auto){
        String motorSedan = generateFeature(MOTORES_SEDAN);
        String motorCamioneta = generateFeature(MOTORES_CAMIONETA);
        String motorSUV = generateFeature(MOTORES_SUV);
        String cabina = generateFeature(CABINAS);
        Boolean tieneSunroof = generateFeature(TIENE_SUNROOF);

        if(auto.getTipo()==TIPO.Sedan){
            auto.setMotor(motorSedan);
        }else if (auto.getTipo()==TIPO.Camioneta){
            auto.setMotor(motorCamioneta);
            auto.setCabinas(cabina);
        }else if (auto.getTipo()==TIPO.SUV){
            auto.setMotor(motorSUV);
            auto.setTieneSunroof(tieneSunroof);
        }

        return auto;

    }




}
