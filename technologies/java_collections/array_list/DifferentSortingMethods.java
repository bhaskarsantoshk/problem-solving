package technologies.java_collections.array_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DifferentSortingMethods {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(28);
        list.add(29);
        list.add(36);
        list.add(5);
        list.add(10);
        list.add(28);

        // Collections.sort(list);
        // List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        // Collections.sort(list, Collections.reverseOrder());
        List<Integer> sortedList = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("ArrayList in asc order: " + sortedList);
    }
}
