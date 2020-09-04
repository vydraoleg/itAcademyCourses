package oleg;

import java.util.Arrays;

public class less4_string {
    public static final String HELLO = "hello";
    public static String someString= HELLO;

    private static void doSome(String str){
        System.out.println(str );
   }
    public static void main(String[] args) {
        String hello = "Hello"; // stringpool
//        someString = "Hello"; // stringpool
        String buy = new String("hello11"); // stringpool
        hello = "Hello11"; // stringpool

        String hello1 = new String("hi"); // heap
        String aa ="a";
        System.out.println(String.join(" ",hello,aa));
        System.out.println(hello.charAt(1) );
        System.out.println(hello.equalsIgnoreCase(buy) );
        System.out.println(hello.startsWith("He"));
        System.out.println(hello.length() );
        System.out.println(hello.indexOf('o') );
        System.out.println(hello.substring(2,5) );
        System.out.println(hello.replace('l','t') );
        String[] s=hello.split("l");
        System.out.println(Arrays.toString(s) );

//        char[] r = hello.getChars(1,3) ;
        String rr=new StringBuilder("Hello, ").append("my ").append("new").toString();
        System.out.println(rr);
        String rr1=new StringBuffer("Hello, ").append("my ").append("new").toString();
        System.out.println(rr1);



        boolean isEqual =hello==buy;
        boolean isEqual1 =hello==someString;

        String hi = new String("Hello");
//        boolean isEqual =hello==hi;
        hi.intern();
        doSome(buy);

    }
}