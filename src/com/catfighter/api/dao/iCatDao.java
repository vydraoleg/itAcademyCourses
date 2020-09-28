package com.catfighter.api.dao;

import com.catfighter.api.exception.CatNotFoundException;
import com.catfighter.entities.Cat;

import java.util.List;

public interface ICatDao {

    List<Cat> getCats();

    void addCat(Cat cat);

    Cat getByName(String name) throws CatNotFoundException;

    void updateCatStrength(String name, int strength) throws CatNotFoundException;

}
