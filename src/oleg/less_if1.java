package oleg;



public class less_if1 {
    public static boolean ch7(int tin){
        if(tin % 10 == 7) return true;
        return false;
    }
    public static boolean chHouse(int ain, int bin, int ein , int fin){
        if ((ain <= ein && bin<=fin ) || (bin <= ein && ain<=fin ) )
             { return true;}
        return false;
    }
    // Можно ли кругом закрыть прямоуголное отверстие
    public static boolean chCircle(int a, int b, int r){
        if (Math.sqrt(a*a+b*b) <= (double) 2*r)
            return true;
        return false;
    }
    public static String rubtext(int a){
        int rt = a%10;
        String rs=" рублей";
        if( rt == 1 && a%100!=11 ) {rs = " рубль";}
        else if ( 1 < rt  && rt < 5  && (a<5 || a>21) ) {rs = " рубля";}
        String res = a + rs;
        return res;
    }
    public static void getday(int day,  int mon, int year){
        day +=1;
        if( day  > 31 ) { day=1; mon +=1;}
        if( mon  > 12 ) { mon =1; year +=1;}
        System.out.println(" "+day+" "+ mon +" " +year);
    }
    public static void main(String[] args) {
//        System.out.println("1070 "+less_if1.ch7(1070));
//        System.out.println(" Можно закрыть "+less_if1.chCircle(2,4,2));
//        System.out.println(less_if1.rubtext(2311));
//        getday(31,  12, 2020);
        int a=2,b=3,c=4,d=5,e=3,f=8;
        if (less_if1.chHouse(a,b,e,f)) {
            System.out.println("Помещается");}
        else {
            System.out.println("не Помещается");}

        if (less_if1.chHouse(c,d,e,f)) {
            System.out.println("Помещается");}
        else {
            System.out.println("не Помещается");}
        int sc=5;

        switch (sc) {
            case 1:
                System.out.println("Расписание 1 день");
                break;
            case 2:
                System.out.println("Расписание 2 день");
                break;
            case 3:
                System.out.println("Расписание 3 день");
                break;
            case 4:
                System.out.println("Расписание 4 день");
                break;
            case 5:
                System.out.println("Расписание 5 день");
                break;
            case 6:
                System.out.println("Расписание 6 день");
                break;
            case 7:
                System.out.println("Расписание 7 день");
                break;
            default:
                System.out.println("День недели с ошибкой");
        }
    }
}
