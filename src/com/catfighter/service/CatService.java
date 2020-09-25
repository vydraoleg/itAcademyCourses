package com.catfighter.service;

import com.catfighter.api.dao.ICatDao;
import com.catfighter.api.service.ICatService;
import com.catfighter.dao.CatDao;
import com.catfighter.entities.Cat;

import java.util.List;

public class CatService implements ICatService {
    ICatDao catDao = new CatDao();

    public List<Cat> getCats(){
//        return catDao.getCats();
        return null;
    }
    // addCat
    //getByName
    //updateCatStrength

}
