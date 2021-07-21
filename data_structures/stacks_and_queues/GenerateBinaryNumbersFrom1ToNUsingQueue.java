package data_structures.stacks_and_queues;

public class GenerateBinaryNumbersFrom1ToNUsingQueue {
    public static String[] getBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new Queue<>(number+1);
        queue.enqueue("1");
        for ( int i=0; i<number; i++){
            result[i] = queue.dequeue();
            String s1 = result[i]+"0";
            String s2 = result[i]+"1";
            queue.enqueue(s1);
            queue.enqueue(s2);
        }
        return result; //For number = 4 , result = {"1","10","11","100"};
    }
}

// Pattern: 1, 10, 11, 100, 101, 110, 111,
