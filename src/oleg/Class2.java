package oleg;

public class Class2 extends Class1 {
    Class2(double d) {
        super((int) d);
//        this((int) d);
        System.out.println("Class2(double)");
    }

    Class2(int i) {
        super(i);   // 2
        System.out.println("Class2(int)");
    }

    public static void main(String[] args) {
        new Class2(0.0);
    }
}

class Class1 {
    Class1(int i) {
        System.out.println("Class1(int)");
    }
}
