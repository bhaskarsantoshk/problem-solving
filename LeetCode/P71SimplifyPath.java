class P71SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        for (String s: path.split("/")){
            if ( s.equals("..")){
                if ( !stack.empty()) stack.pop();
            } 
            else if (s.length()>0 && !s.equals(".")) {
                stack.push(s);
            }
        }
        return "/"+String.join("/", stack);
    }
}