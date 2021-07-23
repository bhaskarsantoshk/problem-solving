package data_structures.stacks_and_queues;
import java.util.Stack;

public class EvaluatePostFixExpressionUsingStack {
    public static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>();
        for ( char c: expression.toCharArray() ){
            if ( c >= '0' && c<= '9'){ // Character.isDigit(c)
                stack.push(Integer.valueOf(""+c)); // Character.getNumericValue(character)
            } else{
                if (stack.size() >= 2){
                    int num2 = stack.pop();
                    int num1 = stack.pop();

                    switch (c){
                        case '+':
                            stack.push(num1+num2);
                            break;
                        case '-':
                            stack.push(num1-num2);
                            break;
                        case '*':
                            stack.push(num1*num2);
                            break;
                        case '/':
                            stack.push(num1/num2);
                            break;
                    }
                }
            }
        }
        return stack.pop();
    }

}
