package com.catfighter.api.service;

import com.catfighter.api.exception.CatNotFoundException;
import com.catfighter.entities.Cat;

import java.util.List;

public interface ICatService {

    List<Cat> getCats();

    void addCat(Cat cat);

    Cat getByName(String name);

    void updateCatStrength(String name, int strength) throws CatNotFoundException;

}
