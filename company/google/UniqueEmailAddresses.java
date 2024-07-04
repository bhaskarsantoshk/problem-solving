package company.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String email : emails){
            String domain = email.split("@")[1];
            String username = getUsername(email.split("@")[0]);
            if (!username.isEmpty()){
                map.computeIfAbsent(domain, k -> new HashSet<>());
                map.get(domain).add(username);
            }
        }
        int result = 0;
        for ( String domain : map.keySet()){
            result += map.get(domain).size();
        }
        return result;
    }

    private static String getUsername(String username){
        char[] letters = username.toCharArray();
        StringBuilder sb = new StringBuilder();
        for ( char c: letters){
            if ( c == '.'){
                continue;
            } else if ( c == '+'){
                break;
            } else {
                sb.append(c+"");
            }
        }
        return sb.toString();
    }

    public int numUniqueEmailsOptimized(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails){
            String[] parts = email.split("@");
            String username = parts[0].split("\\+")[0];
            username = username.replace(".", "");
            emailSet.add(username+"@"+parts[1]);
        }
        return emailSet.size();
    }
}
