package company.apple;

import java.util.*;

public class P54FlattedNestListIterator {
    public interface NestedInteger{
        public boolean isInteger();
        public Integer getInteger();
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer>{

        Queue<Integer> queue;

        public NestedIterator(List<NestedInteger> nestedList) {
            queue = new LinkedList<>();
            dfs(nestedList);
        }

        private void dfs(List<NestedInteger> nestedList) {
            for ( NestedInteger ni: nestedList){
                if ( ni.isInteger()) queue.offer(ni.getInteger());
                else {
                    dfs(ni.getList());
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Integer next() {
            return queue.poll();
        }
    }


    public class NestedIteratorLazy implements Iterator<Integer>{

        Stack<NestedInteger> stack;

        public NestedIteratorLazy(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            addToStack(nestedList);
        }

        private void addToStack(List<NestedInteger> nestedList) {
            for ( int i=nestedList.size()-1; i>=0; i--) stack.push(nestedList.get(i));
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty() && !stack.peek().isInteger()){
                addToStack(stack.pop().getList());
            }
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }
    }
}
