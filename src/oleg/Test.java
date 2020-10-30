package oleg;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Shape> picture = new ArrayList<Shape>
                ();
        picture.add(new Circle());                       // 1
        picture.add(new Rectangle());                    // 2
        Rectangle rect = picture.get(1);                 // 3
    }
}

class Shape {
}

class Circle extends Shape {
}

class Rectangle extends Shape {
}</div>