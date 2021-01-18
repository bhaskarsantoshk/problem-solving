package multithreading.JoiningThreads;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Long> inputNumbers = Arrays.asList(0L, 3435l, 35435l, 2324L, 4656L, 23L, 5556L, 1000000L);

        List<FactorialThread> threads = new ArrayList<>();
        for ( long inputNumber: inputNumbers){
            threads.add(new FactorialThread(inputNumber));
        }
        for ( Thread thread: threads){
            thread.setDaemon(true);
            thread.start();
        }

        for ( Thread thread: threads){
            thread.join(2000); // time out parameter
        }

        for ( int i=0; i < inputNumbers.size(); i++){
            FactorialThread factorialThread = threads.get(i);
            if ( factorialThread.isFinished){
                System.out.println("Factorial of "+ inputNumbers.get(i) + " is "+ factorialThread.getResult());
            }
            else{
                System.out.println("The calculation for factorial of "+ inputNumbers.get(i) + " is "+ "is still in progress");
            }
        }

    }

    public static class FactorialThread extends Thread{
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread( long inputNumber){
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            this.result = factorial(inputNumber);
            this.isFinished = true;
        }

        public BigInteger factorial ( long n){
            BigInteger tmpResult  = BigInteger.ONE;

            for ( long i = n; i>0 ; i--){
                tmpResult = tmpResult.multiply(new BigInteger(Long.toString(i)));
            }
            return  tmpResult;
        }

        public boolean isFinished(){
            return isFinished;
        }
        public BigInteger getResult(){
            return result;
        }
    }
}
