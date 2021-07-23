package data_structures.stacks_and_queues;

public class FindCelebrity {
    public static int findCelebrity(int[][] party, int numPeople) {
        int celebrity = -1;
        Stack<Integer> stack = new Stack<>(numPeople);
        for ( int i=0; i<numPeople; i++){
            stack.push(i);
        }
        while ( !stack.isEmpty() ){
            int x = stack.pop();
            if ( stack.isEmpty() ){
                celebrity = x;
                break;
            }
            int y = stack.pop();
            if ( party[x][y] == 1){
                stack.push(y);
            } else {
                stack.push(x);
            }
        }
        for  (int i=0; i<numPeople; i++){
            if ( celebrity != i && (party[celebrity][i]==1 || party[i][celebrity] == 0 )) return -1;
        }
        return celebrity;
    }
}
