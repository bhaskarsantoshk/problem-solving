package company.google;

import java.util.*;

public class P726NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<Map<String, Integer>>();
        stack.push( new HashMap<>());
        int len = formula.length();
        for ( int i=0; i<len ; ){
            char c = formula.charAt(i);
            if ( c == '('){
                stack.push(new HashMap<>());
                i++;
            } else if ( c == ')'){
                Map<String, Integer> top = stack.pop();
                i++;
                int start = i;
                while ( i < len && Character.isDigit(formula.charAt(i))) i++;
                int multiplier = (start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;
                for ( String key: top.keySet()){
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0)+ top.get(key) * multiplier);
                }
            } else { // Upper case
                int start = i;
                i++;
                while ( i < len && Character.isLowerCase(formula.charAt(i))) i++;
                String element = formula.substring(start, i);
                start = i;
                while ( i < len && Character.isDigit(formula.charAt(i))) i++;
                int count = ( start < i) ? Integer.parseInt(formula.substring(start, i)) : 1;
                stack.peek().put(element, stack.peek().getOrDefault(element, 0)+ count);
            }
        }

        Map<String, Integer> res = stack.pop();
        List<String> elements = new ArrayList<>(res.keySet());
        Collections.sort(elements);
        StringBuilder sb =  new StringBuilder();
        for ( String element : elements){
            sb.append(element);
            int count = res.get(element);
            if ( count > 1) sb.append(count);
        }
        return sb.toString();
    }
}
