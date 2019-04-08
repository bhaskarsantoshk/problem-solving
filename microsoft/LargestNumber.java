package microsoft;

import java.util.Arrays;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {
        StringBuffer sb = new StringBuffer();
        Node num[] = new Node[A.size()-1];
        for(int i=0;i<A.size();i++){
            num[i] = new Node(A.get(i));
        }

        Arrays.sort(num);
        for(int i=0; i<A.size(); i++) {
            if (num[i].number==0 && sb.length() != 0){
                continue;
            }
            sb.append(String.valueOf(num[i].number));
        }
        return sb.toString();
    }

    class Node implements Comparable<Node> {
        int number;
        Node(int num){
            this.number = num;
        }

        @Override
        public int compareTo(Node that) {
            String first = String.valueOf(this.number)+String.valueOf(that.number);
            String second = String.valueOf(that.number)+ String.valueOf(this.number);
            return second.compareTo(first);
        }
    }
}
