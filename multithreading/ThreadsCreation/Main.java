package multithreading.ThreadsCreation;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in the thread : "+ Thread.currentThread().getName());
                System.out.println("Current thread priority is "+ Thread.currentThread().getPriority());
            }
        });
        thread.setName("New Worker Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("We are in the thread : "+ Thread.currentThread().getName() + " before staring a new thread. ");
        thread.start();
        System.out.println("We are in the thread : "+ Thread.currentThread().getName() + " before staring a new thread. ");
        Thread.sleep(1000); // OS is instructed not to schedule the current thread during this time - and this thread will not consume any CPU
    }
}
