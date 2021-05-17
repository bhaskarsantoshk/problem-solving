package multithreading.demo;

import java.util.Random;

public class ThreadUnSafeExample {
    static Random random = new Random();
    public static void main(String[] args) throws InterruptedException {
        ThreadUnsafeCounter counter = new ThreadUnsafeCounter();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                counter.increment();
                ThreadUnSafeExample.sleepRandomly();
            }
        });
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
                ThreadUnSafeExample.sleepRandomly();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        counter.printCounterValue();
    }

    private static void sleepRandomly() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ie) {
        }
    }
}

class ThreadUnsafeCounter {
    int count = 0;

    void increment(){
        count++;
    }
    public void decrement() {
        count--;
    }
    void printCounterValue() {
        System.out.println("counter is: " + count);
    }
}
