package com.itacademy.firstgit.animals;

import lombok.Data;

// java -jar lombok.jar

// @Getter
// @Setter
// @NoArgsCunstructor
// @AllArgsCunstructor
// @SuperBuilder
//@Builder
// @Accessors(chain=true)

@Data
public class Animal2 {
    private String name;
    private int age;
//    private List<String> params;
    private boolean state;
    public void saySmth() {
        System.out.println("say smth");
    }

}
