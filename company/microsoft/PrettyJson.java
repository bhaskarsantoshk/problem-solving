package microsoft;

import java.util.ArrayList;

public class PrettyJson {
    public static ArrayList<String> prettyJSON(String a) {
        ArrayList<String> result = new ArrayList<String>();
        int tabCounter = 0;
        StringBuffer current = new StringBuffer();
        for(int i=0; i<a.length(); i++) {
            char c = a.charAt(i);
            switch(c) {
                case '{':
                case '[':
                    if(current.length() > 0) {
                        result.add(current.toString());
                        current = new StringBuffer();
                    }
                    for(int j=0; j<tabCounter; j++) {
                        current.append('\t');
                    }
                    current.append(c);
                    result.add(current.toString());
                    current = new StringBuffer();
                    tabCounter++;
                    break;

                case ']':
                case '}':
                    if(current.length() > 0) {
                        result.add(current.toString());
                        current = new StringBuffer();
                    }
                    tabCounter--;
                    for(int j=0; j<tabCounter; j++) {
                        current.append('\t');
                    }
                    current.append(c);
                    break;

                case ',':
                    current.append(c);
                    result.add(current.toString());
                    current = new StringBuffer();
                    break;

                default:
                    if(current.length() == 0) {
                        for(int j=0; j<tabCounter; j++) {
                            current.append('\t');
                        }
                    }
                    current.append(c);
            }
        }

        if(current.length() > 0) {
            result.add(current.toString());
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(prettyJSON("[\"foo\", {\"bar\":[\"baz\",null,1.0,2]}]"));
    }
}
