package takeUForward.graph.revision4;

import java.util.*;

public class G39AccountsMerge {
    static List<List<String>> accountsMergeBruteForce(List<List<String>> accounts) {
        Map<String, Set<String>> map = new HashMap<>();
        for ( List<String> emails: accounts ){
            String user = emails.get(0);
            for (int i=1; i<emails.size(); i++){
                if ( map.containsKey(user)){
                    map.get(user).add(emails.get(i));
                } else {
                    map.put(user, new HashSet<>());
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        int i = 0;
        for ( String key: map.keySet()) {
            result.add(new ArrayList<>());
            result.get(i).add(key);
            List<String> values = new ArrayList<>();
            for ( String email: map.get(key)) values.add(email);
            Collections.sort(values);
            result.get(i).addAll(values);
            i++;
        }
        return result;
    }

    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> mapMailNode = new HashMap<>();
       DisjointSet dsu = new DisjointSet(accounts.size());
        for ( int i=0; i<accounts.size(); i++){
            for ( int j=1; j<accounts.get(i).size(); j++){
                if ( !mapMailNode.containsKey(accounts.get(i).get(j))){
                    mapMailNode.put(accounts.get(i).get(j), i);
                } else {
                    dsu.union(i, mapMailNode.get(accounts.get(i).get(j)));
                }
            }
        }
        int n = accounts.size();
        List<String>[] mergedMail = new ArrayList[n];
        for ( int i=0; i < n; i++) mergedMail[i] = new ArrayList<>();
        for ( Map.Entry<String, Integer> entry: mapMailNode.entrySet()){
            String mail = entry.getKey();
            int node = dsu.find(mapMailNode.get(mail));
            mergedMail[node].add(mail);
        }

        List<List<String>> res = new ArrayList<>();
        for ( int i=0; i<n; i++){
            if ( mergedMail[i].isEmpty()) continue;
            Collections.sort(mergedMail[i]);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(i).get(0));
            account.addAll(mergedMail[i]);
            res.add(account);
        }

        return res;

    }

    static class DisjointSet{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet( int n){
            for ( int i=0; i<n; i++){
                parent.add(i);
                size.add(1);
            }
        }

        public int find(int node){
            if ( node == parent.get(node)) return node;
            int uParent = find(parent.get(node));
            parent.set(node, uParent);
            return uParent;
        }

        public void union(int u, int v){
            int parentU = find(u);
            int parentV = find(v);

            if ( parentU == parentV) return;
            if ( size.get(parentU) >= size.get(parentV)){
                parent.set(parentV, parentU);
                size.set(parentU, size.get(parentU)+ size.get(parentV));
            } else {
                parent.set(parentU, parentV);
                size.set(parentV, size.get(parentU)+ size.get(parentV));
            }
        }
    }
}
