package company.google;

import java.util.HashSet;
import java.util.Set;

public class P929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for ( String email : emails){
            // split with @ as delim and get the first part
            email = email.split("@")[0];
            // ignore the string after +
            email = email.split("//+")[0];
            email = email.replace("//.", "");
            emailSet.add(email);
        }
        return emailSet.size();
    }
}
