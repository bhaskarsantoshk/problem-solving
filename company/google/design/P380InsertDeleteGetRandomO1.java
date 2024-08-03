package company.google.design;

import java.util.*;

public class P380InsertDeleteGetRandomO1 {
    Map<Integer, Integer> indexMap;
    List<Integer> list;
    Random random;

    public P380InsertDeleteGetRandomO1() {
        indexMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if ( indexMap.containsKey(val)) return false;
        indexMap.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if ( !indexMap.containsKey(val)) return false;
        int currIndex = indexMap.get(val);
        int lastElement = list.getLast();
        list.set(currIndex, lastElement);
        indexMap.put(lastElement, currIndex);
        list.removeLast();
        indexMap.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
