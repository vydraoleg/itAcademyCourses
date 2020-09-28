package com.catfighter.api.dao;

import com.catfighter.api.exception.CatNotFoundException;
import com.catfighter.entities.Cat;

public interface ICatDao {
    Cat getByName(String name) throws CatNotFoundException;
//    List<Cat> cats = ArrayList<Cat>();

}
