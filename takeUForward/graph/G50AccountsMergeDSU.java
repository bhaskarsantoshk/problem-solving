package takeUForward.graph;
import java.util.*;

public class G50AccountsMergeDSU {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> mapMailNode = new HashMap<>(); // j1->0, j2->0 etc
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        for ( int i=0; i<n; i++){
            for ( int j=1; j<accounts.get(i).size(); j++){ // first index contains name
                String mail = accounts.get(i).get(j);
                if ( !mapMailNode.containsKey(mail)) mapMailNode.put(mail, i);
                else {
                    ds.unionBySize(i, mapMailNode.get(mail)); // there is an edge
                }
            }
        }

        // merged Mail 0->j1, j2
        List<String>[] mergedMail = new ArrayList[n];
        for ( int i=0; i<n; i++) mergedMail[i] = new ArrayList<>();
        for ( Map.Entry<String, Integer> entry : mapMailNode.entrySet()){
            String mail = entry.getKey();
            int node = ds.findParent(entry.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> result = new ArrayList<>();
        for ( int i=0; i<n; i++){
            if ( mergedMail[i].isEmpty()) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedMail[i]);
            result.add(temp);
        }
        return result;
    }

    static class DisjointSet{
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n){
            for ( int i=0; i<=n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public void unionBySize(int u, int v){
            int uParent = findParent(u);
            int vParent = findParent(v);
            if ( uParent == vParent) return;
            if ( size.get(uParent) > size.get(vParent)){
                parent.set(vParent, uParent);
                size.set(uParent, size.get(uParent)+1);
            } else {
                parent.set(uParent, vParent);
                size.set(vParent, size.get(vParent)+1);
            }
        }

        public int findParent(int node){
            if (node == parent.get(node)) return node;
            int uParent = findParent(parent.get(node));
            parent.set(node, uParent);
            return uParent;
        }

    }
}
