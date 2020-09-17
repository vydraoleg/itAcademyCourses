package oleg;

public class less_mas {
    public static void main(String[] args) {
        int[] array = new int[10];
        System.out.println(array.length);
        array = new int[20];
        System.out.println(array.length);
        double[][] arrayDouble = new double[10][20];
        System.out.println(arrayDouble.length + " " + arrayDouble[0].length);
        for (int i = 0; i < arrayDouble.length; i++) {
            for (int j = 0; j < arrayDouble[i].length; j++) {
                arrayDouble[i][j] = (double) Math.random() * 111.111;
                System.out.print(arrayDouble[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
