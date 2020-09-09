package oleg;
public class Less2 {

    static int MyCalc(int p1, int p2){
        int res;
        res = p1+p2 +(p1*p2);
        return res;
    }
    static void MyTimeShift(long myp ){
        long temp = myp;
        long sec  =  temp % 60;
        temp /= 60;
        long min  =  temp % 60;
        temp /= 60;
        long hour =  temp % 24;
        temp /= 24;
        long day =  temp % 7;
        temp /=  7;

        System.out.println("недель = "+ temp + " дней= "+day+ " время = "+hour+ ":"+min+ ":"+sec);

    }
    public static void main(String[] args) {

/*        byte b = 0x55;
        short s = 0x55ff;
        int i = 1000000;
        long l = 0xffffffffL;
        System.out.println("b = "+b);
        System.out.println("s = "+s);
        System.out.println("i = "+i);
        System.out.println("l = "+l);
 */
        int k1 = 20, k2 = 3;
        int k3 = Less2.MyCalc(k1,k2);

        System.out.println("k3 = "+ Integer.compare(19,9));

        long rr=2231234;
        Less2.MyTimeShift(rr);
    }
}
