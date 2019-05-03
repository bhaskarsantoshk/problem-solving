package company.microsoft;

import java.util.Stack;

public class SimplifyDirectoryPath {
    public String simplifyPath(String A) {
        String[] arr = A.split("/");
        Stack<String> stack = new Stack<>();

        for(String s: arr){
            if(s.length() == 0 || s.equals(".")){
                continue;
            }
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(s);
            }
        }

        return "/"+ String.join("/", stack.toArray(new String[0]));
    }
}
