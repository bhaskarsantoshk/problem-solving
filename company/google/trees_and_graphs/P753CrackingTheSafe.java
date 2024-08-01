package company.google.trees_and_graphs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P753CrackingTheSafe {
    public String crackSafe(int n, int k) {
        StringBuilder res = new StringBuilder();
        Set<String> visited = new HashSet<>();
        String start = String.join("", Collections.nCopies(n-1, "0"));
        res.append(start);
        dfs(start, k, visited, res);
        return res.toString();
    }

    private void dfs(String node, int k, Set<String> visited, StringBuilder res) {
        for ( int i=0; i<k; i++){
            String next = node+i;
            if ( !visited.contains(next)){
                visited.add(next);
                dfs(next.substring(1), k, visited, res);
                res.append(i);
            }
        }
    }
}
