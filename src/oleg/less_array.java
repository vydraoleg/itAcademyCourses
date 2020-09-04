package oleg;

public class less_array {
    public static void main(String[] args) {
        int mas[] = new int[10];
        for (int index = 0; index<10; index++){
            mas[index] = (int) (Math.random()*100);
            if (index%2==0)
                System.out.println(index+" = " +mas[index]);
        }
    }
}
