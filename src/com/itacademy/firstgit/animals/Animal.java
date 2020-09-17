package com.itacademy.firstgit.animals;

//import com.oracle.webservices.internal.api.databinding.DatabindingMode;

import java.util.List;
import java.util.Objects;

//<T> Generic

public abstract class Animal<T extends Number> {
    private String name;
    private T age;
    private List<String> params;

    public Animal(){
        super();
    }

    public Animal(String name, T age, List<String> params) {
        super();
        this.name = name;
        this.age = age;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public void saySmth() {
        System.out.println("say smth");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal<?> animal = (Animal<?>) o;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
    // HashCodeBuilder() есть готовый

}
