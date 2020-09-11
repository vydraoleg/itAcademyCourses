package com.itacademy.firstgit.animals;

import java.util.List;

//<T> Generic
public abstract class Animal<T extends Number> {
        private String name;
        private T age;
//        List<String> params;

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

        public void saySmth(){
            System.out.println("say smth");
        }
}
