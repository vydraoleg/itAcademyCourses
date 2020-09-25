package com.catfighter.dao;

import com.catfighter.api.dao.ICatDao;
import com.catfighter.entities.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatDao implements ICatDao {
    private List<Cat> cats = new ArrayList<>();

    public List<Cat> getCat() {
        return cats;
    }

    public void addCat(Cat cat) {
        cats.add(cat);
        System.out.println(" Cat was added, "+cat.toString());
    }

    public Cat getByName(String name) {
        Optional<Cat> optionalCat =
                cats.stream()
                        .filter(x -> x.getName().equals(name))
                        .findFirst();
        Cat cat = optionalCat.orElse(null);
        return cat;
    }
    public void updateCatStrength(String name, int strength ){
        Cat cat = this.getByName(name);
        cat.setStrength(strength);
        System.out.println(" Cat was updated, "+cat.toString());
    }

    public void  setCat(List<Cat> cats) {
        this.cats = cats;
    }


}
