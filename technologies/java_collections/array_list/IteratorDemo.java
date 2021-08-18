package technologies.java_collections.array_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(4);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // forEachRemaining()
        Iterator<Integer> newIterator = list.iterator();
        newIterator.forEachRemaining( o -> System.out.println(o));

        Iterator<Integer> iteratorToRemove = list.iterator();
        while (iteratorToRemove.hasNext()) {
            int next = iteratorToRemove.next();
            if (next == 30) {
                // list.remove(Integer.valueOf(2)); will throw Exception
                newIterator.remove();
            }
        }
    }
}
