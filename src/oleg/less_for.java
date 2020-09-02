package oleg;

public class less_for {
    public static void main(String[] args) {
// Task 12
        int j = 10;
        int fac = 1;
        while( j > 1 ) { fac *= j; j--;}
        System.out.println(fac);
// Task 13
        j = 25;
        fac = 1;
        do{ fac*=j; j--;}while(j>1);
        System.out.println(fac);
// Task 14
        long l1 = 793823445;
        int sum = 0;
        do{
            sum += l1 % 10;
            l1 /=  10;
        }while(l1 > 0);
        System.out.println(sum);

// Task 15
  
        for(int i = 50; i<=70 ; i++) {
            System.out.println(i + i);
        }

// Task 16
        for(int i = 1; i<=100 ; i++) {
            if(i%7==0) System.out.println(i + " Hope");
        }


    }
}
