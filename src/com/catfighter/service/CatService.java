package com.catfighter.service;

import com.catfighter.api.dao.ICatDao;
import com.catfighter.api.service.ICatService;
import com.catfighter.dao.CatDao;
import com.catfighter.entities.Cat;
import com.catfighter.utils.CriticalHitCounter;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.List;

public class CatService implements ICatService {
    ICatDao catDao = new CatDao();

    public List<Cat> getCats(){
//        return catDao.getCats();
        return null;
    }

    public Cat getByName(String name) {
        try {
            return catDao.getByName(name);
        } catch (Exception e) {
            e.printStackTrace(); // Выкинуть в логи всю цепочку
            System.out.println("Exception caught!");
            Cat cat1 = new Cat(name, 0, 0);
            // this.catDao.addCat(cat1);
            return cat1;
        } finally {
            System.out.println("...");
        }
    }
    //updateCatStrength
    public void doSmth(){
        try {
            CriticalHitCounter.doSmth();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
