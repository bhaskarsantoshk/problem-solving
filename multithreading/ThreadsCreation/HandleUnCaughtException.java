package multithreading.ThreadsCreation;

public class HandleUnCaughtException {
    public static void main(String[] args){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Internal Exception");
            }
        });
        thread.setName("Misbehaving thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error occurred in thread " + t.getName() +
                        " the error is "+ e.getMessage());
            }
        });
        thread.start();
    }
}
