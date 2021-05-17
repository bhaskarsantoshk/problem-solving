package multithreading.demo;

public class Counter {
    long start;
    long end;
    long counter = 0;
    static long MAX = Integer.MAX_VALUE;

    public Counter(long start, long end){
        this.start = start;
        this.end = end;
    }

    public void add(){
        for ( long i = start; i<= end; i++){
            counter+= i;
        }
    }

    static public void getSum() {
        long start = System.currentTimeMillis();
        Counter s = new Counter(1, MAX);
        s.add();
        long end = System.currentTimeMillis();
        System.out.println("Single thread final count = " + s.counter + " took " + (end - start));
    }

    static public void getSumUsingThreads () throws InterruptedException {
        long start = System.currentTimeMillis();
        Counter s1 = new Counter(1, MAX/2);
        Thread t1 = new Thread(()->{
            s1.add();
        });

        Counter s2 = new Counter(MAX/2 + 1, MAX);
        Thread t2 = new Thread(()->{
            s2.add();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        long finalCount = s1.counter + s2.counter;
        long end = System.currentTimeMillis();
        System.out.println("Two threads final count = " + finalCount + " took " + (end - start));
    }
    public static void checkPerformance() throws InterruptedException {
        getSum();
        getSumUsingThreads();
    }
}

class Demo {
    public static void main( String args[] ) throws InterruptedException {
        Counter.checkPerformance();
    }
}
