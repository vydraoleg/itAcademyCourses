package com.animalfighter;

import com.animalfighter.entities.Animal;
import com.animalfighter.utils.SerializationUtil;

public class MainSerialisation {
    public static void main(String[] args) {
        Animal fighter1 = new SerializationUtil().deserialize("..\\animal1.info");
        Animal fighter2 = new SerializationUtil().deserialize("..\\animal2.info");
    }
}
