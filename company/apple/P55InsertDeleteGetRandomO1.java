package company.apple;

import java.util.*;

public class P55InsertDeleteGetRandomO1 {
    public class RandomizedSet {

        Random random;
        List<Integer> list;
        Map<Integer, Integer> map;
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if ( map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if ( !map.containsKey(val)) return false;
            int index = map.get(val);
            // swap with last element in list
            Collections.swap(list, index, list.size()-1);
            map.put(list.get(index), index);
            list.remove(list.size()-1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
