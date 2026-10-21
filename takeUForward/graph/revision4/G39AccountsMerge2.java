package takeUForward.graph.revision4;

import java.util.*;

public class G39AccountsMerge2 {

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // mail - node
        Map<String, Integer> mapMailNode = new HashMap<>();
        int n = accounts.size();
        DisjointSet dsu = new DisjointSet(n);
        for ( int i=0; i<n; i++){
            for ( int j=1; j<accounts.get(i).size(); j++){
                String mail = accounts.get(i).get(j);
                if (!mapMailNode.containsKey(mail)) mapMailNode.put(mail, i);
                else dsu.union(i, mapMailNode.get(mail));
            }
        }

        List<String>[] mailMerge = new ArrayList[n];
        for ( int i=0; i<n; i++) mailMerge[i] = new ArrayList<>();
        for ( Map.Entry<String, Integer> entry: mapMailNode.entrySet()){
            String mail = entry.getKey();
            int node = dsu.find(entry.getValue());
            mailMerge[node].add(mail);
        }
        List<List<String>> result = new ArrayList<>();
        for ( int i=0; i<n; i++) {
            if ( mailMerge[i].isEmpty()) continue;
            List<String> subList = new ArrayList<>();
            Collections.sort(mailMerge[i]);
            subList.add(accounts.get(i).get(0));
            subList.addAll(mailMerge[i]);
            result.add(subList);
        }
        return result;
    }

    static class DisjointSet{
        List<Integer> parent, size;
        DisjointSet(int n){
            parent = new ArrayList<>();
            size = new ArrayList<>();
            for ( int i=0; i<n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int find(int node){
            if ( node == parent.get(node)) return node;
            int ultimateParent = find(parent.get(node));
            parent.set(node, ultimateParent);
            return ultimateParent;
        }

        public void union(int u, int v){
            int uParent = find(u);
            int vParent = find(v);
            if ( uParent == vParent) return;
            if ( size.get(uParent) >= size.get(vParent)){
                parent.set(vParent, uParent);
                size.set(uParent, size.get(uParent)+ size.get(vParent));
            } else {
                parent.set(uParent, vParent);
                size.set(vParent, size.get(uParent)+ size.get(vParent));
            }
        }
    }
}
