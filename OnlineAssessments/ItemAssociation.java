package OnlineAssessments;

import java.util.*;

import static Utility.Utility.print;

public class ItemAssociation {

    static class PairString
    {
        String first;
        String second;

        PairString(String first, String second)
        {
            this.first = first;
            this.second = second;
        }
    }

    static List<String> getLargestItemAssociation(List<PairString> itemAssociation) {
        Map<String, Set<String>> association = new TreeMap<>();
        for (PairString pair: itemAssociation){
            association.computeIfAbsent(pair.first, k->new TreeSet<>()).add(pair.first);
            association.computeIfAbsent(pair.second, k->new TreeSet<>()).add(pair.second);
            association.get(pair.first).add(pair.second);
            association.get(pair.second).add(pair.first);
        }
        int max = 0;
        Set<String> maxSet = null;
        for ( Map.Entry<String, Set<String>> entry: association.entrySet()){
            if (entry.getValue().size() > max){
                maxSet = entry.getValue();
                max = maxSet.size();
            }
        }
        List<String> result = new ArrayList<>(maxSet);
        return result;
    }


    public static void main(String[] args) {

        PairString p1 = new PairString("A", "B");
        PairString p2 = new PairString("B", "C");
        PairString p3 = new PairString("C", "H");
        PairString p4 = new PairString("D", "E");
        List<PairString> itemAssociation = new ArrayList<>();
        itemAssociation.add(p1);
        itemAssociation.add(p2);
        itemAssociation.add(p3);
        itemAssociation.add(p4);

        System.out.println(getLargestItemAssociation(itemAssociation));
    }

}
