package oleg;

import com.entity.Child;
import com.entity.RunnableTest;
import com.entity.ThreadTest;

public class Less1009Threads {
    static ThreadTest tTest1;
    static ThreadTest tTest2;
    static RunnableTest rTest1;
    static RunnableTest rTest2;

    public static void main(String[] args) throws InterruptedException {

        tTest1 = new ThreadTest();
//        tTest1.setName("Thread One");
        tTest1.start();

        tTest2 = new ThreadTest();
//        tTest2.setName("Thread Second");
        tTest2.start();

        rTest1 = new RunnableTest();
        Thread newThread1 = new Thread(rTest1);
        newThread1.start();

        rTest2 = new RunnableTest();
        Thread newThread2 = new Thread(rTest2);
        newThread2.start();
    }
}
