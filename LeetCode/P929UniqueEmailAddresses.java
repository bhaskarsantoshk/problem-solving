package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class P929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmailSet = new HashSet<String>();
        for(String email: emails){
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            uniqueEmailSet.add(local[0].replace(".", "")+"@"+parts[1]);
        }
        return uniqueEmailSet.size();
    }
}
